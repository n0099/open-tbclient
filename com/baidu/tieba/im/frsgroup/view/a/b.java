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
    private g djG;
    private PbListView dnG;
    private h gId;
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

    public void dc(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.aa(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void cy(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void bus() {
        bDO();
        this.dnG.akD();
    }

    public void but() {
        bDO();
        this.dnG.setText(this.mContext.getResources().getString(R.string.network_ungeilivable));
        this.dnG.akE();
    }

    public void buu() {
        bDO();
        this.dnG.setText(this.mContext.getResources().getString(R.string.list_no_more));
        this.dnG.akE();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.dnG != null) {
            this.dnG.iU(R.color.cp_bg_line_c);
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnG.iV(i);
        }
        if (this.gId != null) {
            this.gId.onChangeSkinType();
        }
        if (this.djG != null) {
            this.djG.onChangeSkinType();
        }
    }

    public void bDN() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.dnG = null;
        }
    }

    private void bDO() {
        if (this.mListView != null && this.dnG == null) {
            this.dnG = new PbListView(this.mContext.getPageActivity());
            this.dnG.nZ();
            this.mListView.setNextPage(this.dnG);
        }
    }

    public void showLoadingView() {
        if (this.djG == null) {
            this.djG = new g(this.mContext.getPageActivity(), BdListViewHelper.cCz);
            this.djG.onChangeSkinType();
        }
        if (!this.djG.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.djG.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.djG != null && this.djG.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.djG.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gId == null) {
            this.gId = new h(this.mContext.getPageActivity(), onClickListener);
            this.gId.kK(BdListViewHelper.cCz);
            this.gId.onChangeSkinType();
        }
        if (!this.gId.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.invite_friend_no_data_now);
            }
            this.gId.setTitle(str);
            this.gId.attachView(this.mRootView, true);
            this.gId.atI();
        }
    }

    public void aJh() {
        if (this.gId != null && this.gId.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.gId.dettachView(this.mRootView);
        }
    }
}
