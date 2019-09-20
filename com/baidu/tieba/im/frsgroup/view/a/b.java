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
    private g dly;
    private PbListView dpz;
    private h gKN;
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

    public void mp(boolean z) {
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

    public void bvt() {
        bEQ();
        this.dpz.akR();
    }

    public void bvu() {
        bEQ();
        this.dpz.setText(this.mContext.getResources().getString(R.string.network_ungeilivable));
        this.dpz.akS();
    }

    public void bvv() {
        bEQ();
        this.dpz.setText(this.mContext.getResources().getString(R.string.list_no_more));
        this.dpz.akS();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.dpz != null) {
            this.dpz.iX(R.color.cp_bg_line_c);
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dpz.iY(i);
        }
        if (this.gKN != null) {
            this.gKN.onChangeSkinType();
        }
        if (this.dly != null) {
            this.dly.onChangeSkinType();
        }
    }

    public void bEP() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.dpz = null;
        }
    }

    private void bEQ() {
        if (this.mListView != null && this.dpz == null) {
            this.dpz = new PbListView(this.mContext.getPageActivity());
            this.dpz.nZ();
            this.mListView.setNextPage(this.dpz);
        }
    }

    public void showLoadingView() {
        if (this.dly == null) {
            this.dly = new g(this.mContext.getPageActivity(), BdListViewHelper.cDC);
            this.dly.onChangeSkinType();
        }
        if (!this.dly.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.dly.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.dly != null && this.dly.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.dly.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gKN == null) {
            this.gKN = new h(this.mContext.getPageActivity(), onClickListener);
            this.gKN.kO(BdListViewHelper.cDC);
            this.gKN.onChangeSkinType();
        }
        if (!this.gKN.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.invite_friend_no_data_now);
            }
            this.gKN.setTitle(str);
            this.gKN.attachView(this.mRootView, true);
            this.gKN.atW();
        }
    }

    public void aJN() {
        if (this.gKN != null && this.gKN.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.gKN.dettachView(this.mRootView);
        }
    }
}
