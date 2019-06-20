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
    private g dhY;
    private PbListView dlY;
    private h gBT;
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

    public void lY(boolean z) {
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

    public void bsr() {
        bBh();
        this.dlY.ajy();
    }

    public void bss() {
        bBh();
        this.dlY.setText(this.mContext.getResources().getString(R.string.network_ungeilivable));
        this.dlY.ajz();
    }

    public void bst() {
        bBh();
        this.dlY.setText(this.mContext.getResources().getString(R.string.list_no_more));
        this.dlY.ajz();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.dlY != null) {
            this.dlY.iO(R.color.cp_bg_line_c);
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlY.iP(i);
        }
        if (this.gBT != null) {
            this.gBT.onChangeSkinType();
        }
        if (this.dhY != null) {
            this.dhY.onChangeSkinType();
        }
    }

    public void bBg() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.dlY = null;
        }
    }

    private void bBh() {
        if (this.mListView != null && this.dlY == null) {
            this.dlY = new PbListView(this.mContext.getPageActivity());
            this.dlY.nG();
            this.mListView.setNextPage(this.dlY);
        }
    }

    public void showLoadingView() {
        if (this.dhY == null) {
            this.dhY = new g(this.mContext.getPageActivity(), BdListViewHelper.cBi);
            this.dhY.onChangeSkinType();
        }
        if (!this.dhY.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.dhY.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.dhY != null && this.dhY.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.dhY.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gBT == null) {
            this.gBT = new h(this.mContext.getPageActivity(), onClickListener);
            this.gBT.kE(BdListViewHelper.cBi);
            this.gBT.onChangeSkinType();
        }
        if (!this.gBT.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.invite_friend_no_data_now);
            }
            this.gBT.setTitle(str);
            this.gBT.attachView(this.mRootView, true);
            this.gBT.asB();
        }
    }

    public void aHK() {
        if (this.gBT != null && this.gBT.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.gBT.dettachView(this.mRootView);
        }
    }
}
