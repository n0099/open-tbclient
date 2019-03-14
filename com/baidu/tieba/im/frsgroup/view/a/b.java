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
    private g cXm;
    private PbListView dbn;
    private h gkP;
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

    public void cV(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.T(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void cs(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void bkX() {
        btu();
        this.dbn.aeC();
    }

    public void bkY() {
        btu();
        this.dbn.setText(this.mContext.getResources().getString(d.j.network_ungeilivable));
        this.dbn.aeD();
    }

    public void bkZ() {
        btu();
        this.dbn.setText(this.mContext.getResources().getString(d.j.list_no_more));
        this.dbn.aeD();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.l(this.mListView, d.C0277d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.dbn != null) {
            this.dbn.ib(d.C0277d.cp_bg_line_c);
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbn.ic(i);
        }
        if (this.gkP != null) {
            this.gkP.onChangeSkinType();
        }
        if (this.cXm != null) {
            this.cXm.onChangeSkinType();
        }
    }

    public void btt() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.dbn = null;
        }
    }

    private void btu() {
        if (this.mListView != null && this.dbn == null) {
            this.dbn = new PbListView(this.mContext.getPageActivity());
            this.dbn.oM();
            this.mListView.setNextPage(this.dbn);
        }
    }

    public void showLoadingView() {
        if (this.cXm == null) {
            this.cXm = new g(this.mContext.getPageActivity(), BdListViewHelper.csV);
            this.cXm.onChangeSkinType();
        }
        if (!this.cXm.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.cXm.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.cXm != null && this.cXm.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.cXm.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gkP == null) {
            this.gkP = new h(this.mContext.getPageActivity(), onClickListener);
            this.gkP.jR(BdListViewHelper.csV);
            this.gkP.onChangeSkinType();
        }
        if (!this.gkP.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.invite_friend_no_data_now);
            }
            this.gkP.setTitle(str);
            this.gkP.attachView(this.mRootView, true);
            this.gkP.anB();
        }
    }

    public void aBt() {
        if (this.gkP != null && this.gkP.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.gkP.dettachView(this.mRootView);
        }
    }
}
