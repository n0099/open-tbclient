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
    private BdTypeListView faQ;
    private PbListView fbY;
    private g fkQ;
    private h iBQ;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.dIF = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.faQ = new BdTypeListView(tbPageContext.getPageActivity());
        this.faQ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.faQ.setSelector(17170445);
        this.faQ.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.dIF);
        this.mPullView.setTag(this.dIF.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.faQ.setOnSrollToBottomListener(cVar);
        this.faQ.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.faQ, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.faQ);
    }

    public void pk(boolean z) {
        if (this.mHeaderView != null && this.faQ != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void di(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.faQ.addAdapters(list);
        }
    }

    public void cH(List<o> list) {
        if (list != null) {
            this.faQ.setData(list);
        }
    }

    public void completePullRefresh() {
        this.faQ.completePullRefreshPostDelayed(0L);
    }

    public void cdN() {
        cmO();
        this.fbY.startLoadData();
    }

    public void cdO() {
        cmO();
        this.fbY.setText(this.dIF.getResources().getString(R.string.network_ungeilivable));
        this.fbY.endLoadData();
    }

    public void cdP() {
        cmO();
        this.fbY.setText(this.dIF.getResources().getString(R.string.list_no_more));
        this.fbY.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.faQ, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fbY != null) {
            this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fbY.changeSkin(i);
        }
        if (this.iBQ != null) {
            this.iBQ.onChangeSkinType();
        }
        if (this.fkQ != null) {
            this.fkQ.onChangeSkinType();
        }
    }

    public void cmN() {
        if (this.faQ != null) {
            this.faQ.setNextPage(null);
            this.fbY = null;
        }
    }

    private void cmO() {
        if (this.faQ != null && this.fbY == null) {
            this.fbY = new PbListView(this.dIF.getPageActivity());
            this.fbY.createView();
            this.faQ.setNextPage(this.fbY);
        }
    }

    public void showLoadingView() {
        if (this.fkQ == null) {
            this.fkQ = new g(this.dIF.getPageActivity(), BdListViewHelper.euP);
            this.fkQ.onChangeSkinType();
        }
        if (!this.fkQ.isViewAttached()) {
            this.faQ.setVisibility(8);
            this.fkQ.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.fkQ != null && this.fkQ.isViewAttached()) {
            this.faQ.setVisibility(0);
            this.fkQ.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.iBQ == null) {
            this.iBQ = new h(this.dIF.getPageActivity(), onClickListener);
            this.iBQ.setLayoutMargin(BdListViewHelper.euP);
            this.iBQ.onChangeSkinType();
        }
        if (!this.iBQ.isViewAttached()) {
            this.faQ.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.dIF.getString(R.string.invite_friend_no_data_now);
            }
            this.iBQ.setTitle(str);
            this.iBQ.attachView(this.mRootView, true);
            this.iBQ.showRefreshButton();
        }
    }

    public void bqO() {
        if (this.iBQ != null && this.iBQ.isViewAttached()) {
            this.faQ.setVisibility(0);
            this.iBQ.dettachView(this.mRootView);
        }
    }
}
