package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
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
    private TbPageContext<?> dIF;
    private BdTypeListView fbb;
    private PbListView fcj;
    private g flb;
    private h iCD;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.dIF = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fbb = new BdTypeListView(tbPageContext.getPageActivity());
        this.fbb.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fbb.setSelector(17170445);
        this.fbb.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.dIF);
        this.mPullView.setTag(this.dIF.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.fbb.setOnSrollToBottomListener(cVar);
        this.fbb.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.fbb, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.fbb);
    }

    public void pk(boolean z) {
        if (this.mHeaderView != null && this.fbb != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dj(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.fbb.addAdapters(list);
        }
    }

    public void cI(List<o> list) {
        if (list != null) {
            this.fbb.setData(list);
        }
    }

    public void completePullRefresh() {
        this.fbb.completePullRefreshPostDelayed(0L);
    }

    public void cdV() {
        cmX();
        this.fcj.startLoadData();
    }

    public void cdW() {
        cmX();
        this.fcj.setText(this.dIF.getResources().getString(R.string.network_ungeilivable));
        this.fcj.endLoadData();
    }

    public void cdX() {
        cmX();
        this.fcj.setText(this.dIF.getResources().getString(R.string.list_no_more));
        this.fcj.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.fbb, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fcj != null) {
            this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fcj.changeSkin(i);
        }
        if (this.iCD != null) {
            this.iCD.onChangeSkinType();
        }
        if (this.flb != null) {
            this.flb.onChangeSkinType();
        }
    }

    public void cmW() {
        if (this.fbb != null) {
            this.fbb.setNextPage(null);
            this.fcj = null;
        }
    }

    private void cmX() {
        if (this.fbb != null && this.fcj == null) {
            this.fcj = new PbListView(this.dIF.getPageActivity());
            this.fcj.createView();
            this.fbb.setNextPage(this.fcj);
        }
    }

    public void showLoadingView() {
        if (this.flb == null) {
            this.flb = new g(this.dIF.getPageActivity(), BdListViewHelper.euP);
            this.flb.onChangeSkinType();
        }
        if (!this.flb.isViewAttached()) {
            this.fbb.setVisibility(8);
            this.flb.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.flb != null && this.flb.isViewAttached()) {
            this.fbb.setVisibility(0);
            this.flb.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.iCD == null) {
            this.iCD = new h(this.dIF.getPageActivity(), onClickListener);
            this.iCD.setLayoutMargin(BdListViewHelper.euP);
            this.iCD.onChangeSkinType();
        }
        if (!this.iCD.isViewAttached()) {
            this.fbb.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.dIF.getString(R.string.invite_friend_no_data_now);
            }
            this.iCD.setTitle(str);
            this.iCD.attachView(this.mRootView, true);
            this.iCD.showRefreshButton();
        }
    }

    public void bqQ() {
        if (this.iCD != null && this.iCD.isViewAttached()) {
            this.fbb.setVisibility(0);
            this.iCD.dettachView(this.mRootView);
        }
    }
}
