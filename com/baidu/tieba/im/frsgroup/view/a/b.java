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
    private g djN;
    private PbListView dnN;
    private h gIV;
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
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.kc());
        this.mRootView.addView(this.mListView);
    }

    public void mm(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void db(List<com.baidu.adp.widget.ListView.a> list) {
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

    public void buF() {
        bEc();
        this.dnN.akF();
    }

    public void buG() {
        bEc();
        this.dnN.setText(this.mContext.getResources().getString(R.string.network_ungeilivable));
        this.dnN.akG();
    }

    public void buH() {
        bEc();
        this.dnN.setText(this.mContext.getResources().getString(R.string.list_no_more));
        this.dnN.akG();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.dnN != null) {
            this.dnN.iU(R.color.cp_bg_line_c);
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnN.iV(i);
        }
        if (this.gIV != null) {
            this.gIV.onChangeSkinType();
        }
        if (this.djN != null) {
            this.djN.onChangeSkinType();
        }
    }

    public void bEb() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.dnN = null;
        }
    }

    private void bEc() {
        if (this.mListView != null && this.dnN == null) {
            this.dnN = new PbListView(this.mContext.getPageActivity());
            this.dnN.nZ();
            this.mListView.setNextPage(this.dnN);
        }
    }

    public void showLoadingView() {
        if (this.djN == null) {
            this.djN = new g(this.mContext.getPageActivity(), BdListViewHelper.cCG);
            this.djN.onChangeSkinType();
        }
        if (!this.djN.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.djN.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.djN != null && this.djN.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.djN.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gIV == null) {
            this.gIV = new h(this.mContext.getPageActivity(), onClickListener);
            this.gIV.kL(BdListViewHelper.cCG);
            this.gIV.onChangeSkinType();
        }
        if (!this.gIV.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.invite_friend_no_data_now);
            }
            this.gIV.setTitle(str);
            this.gIV.attachView(this.mRootView, true);
            this.gIV.atK();
        }
    }

    public void aJj() {
        if (this.gIV != null && this.gIV.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.gIV.dettachView(this.mRootView);
        }
    }
}
