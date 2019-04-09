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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private g cXq;
    private PbListView dbs;
    private h gkD;
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
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.kY());
        this.mRootView.addView(this.mListView);
    }

    public void li(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cS(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.T(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void cp(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void bkU() {
        btr();
        this.dbs.aez();
    }

    public void bkV() {
        btr();
        this.dbs.setText(this.mContext.getResources().getString(d.j.network_ungeilivable));
        this.dbs.aeA();
    }

    public void bkW() {
        btr();
        this.dbs.setText(this.mContext.getResources().getString(d.j.list_no_more));
        this.dbs.aeA();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.l(this.mListView, d.C0277d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.dbs != null) {
            this.dbs.ia(d.C0277d.cp_bg_line_c);
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbs.ib(i);
        }
        if (this.gkD != null) {
            this.gkD.onChangeSkinType();
        }
        if (this.cXq != null) {
            this.cXq.onChangeSkinType();
        }
    }

    public void btq() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.dbs = null;
        }
    }

    private void btr() {
        if (this.mListView != null && this.dbs == null) {
            this.dbs = new PbListView(this.mContext.getPageActivity());
            this.dbs.oM();
            this.mListView.setNextPage(this.dbs);
        }
    }

    public void showLoadingView() {
        if (this.cXq == null) {
            this.cXq = new g(this.mContext.getPageActivity(), BdListViewHelper.csY);
            this.cXq.onChangeSkinType();
        }
        if (!this.cXq.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.cXq.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.cXq != null && this.cXq.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.cXq.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gkD == null) {
            this.gkD = new h(this.mContext.getPageActivity(), onClickListener);
            this.gkD.jQ(BdListViewHelper.csY);
            this.gkD.onChangeSkinType();
        }
        if (!this.gkD.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.invite_friend_no_data_now);
            }
            this.gkD.setTitle(str);
            this.gkD.attachView(this.mRootView, true);
            this.gkD.any();
        }
    }

    public void aBq() {
        if (this.gkD != null && this.gkD.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.gkD.dettachView(this.mRootView);
        }
    }
}
