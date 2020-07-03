package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private TbPageContext<?> dPv;
    private BdTypeListView fml;
    private PbListView fnt;
    private g fwo;
    private h iTH;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.dPv = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fml = new BdTypeListView(tbPageContext.getPageActivity());
        this.fml.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fml.setSelector(17170445);
        this.fml.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.dPv);
        this.mPullView.setTag(this.dPv.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.fml.setOnSrollToBottomListener(cVar);
        this.fml.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.fml, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.fml);
    }

    public void pu(boolean z) {
        if (this.mHeaderView != null && this.fml != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dx(List<com.baidu.adp.widget.ListView.a> list) {
        if (!w.isEmpty(list)) {
            this.fml.addAdapters(list);
        }
    }

    public void cS(List<q> list) {
        if (list != null) {
            this.fml.setData(list);
        }
    }

    public void completePullRefresh() {
        this.fml.completePullRefreshPostDelayed(0L);
    }

    public void chs() {
        cqM();
        this.fnt.startLoadData();
    }

    public void cht() {
        cqM();
        this.fnt.setText(this.dPv.getResources().getString(R.string.network_ungeilivable));
        this.fnt.endLoadData();
    }

    public void chu() {
        cqM();
        this.fnt.setText(this.dPv.getResources().getString(R.string.list_no_more));
        this.fnt.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.fml, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fnt != null) {
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
        if (this.iTH != null) {
            this.iTH.onChangeSkinType();
        }
        if (this.fwo != null) {
            this.fwo.onChangeSkinType();
        }
    }

    public void cqL() {
        if (this.fml != null) {
            this.fml.setNextPage(null);
            this.fnt = null;
        }
    }

    private void cqM() {
        if (this.fml != null && this.fnt == null) {
            this.fnt = new PbListView(this.dPv.getPageActivity());
            this.fnt.createView();
            this.fml.setNextPage(this.fnt);
        }
    }

    public void showLoadingView() {
        if (this.fwo == null) {
            this.fwo = new g(this.dPv.getPageActivity(), BdListViewHelper.eDT);
            this.fwo.onChangeSkinType();
        }
        if (!this.fwo.isViewAttached()) {
            this.fml.setVisibility(8);
            this.fwo.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null && this.fwo.isViewAttached()) {
            this.fml.setVisibility(0);
            this.fwo.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.iTH == null) {
            this.iTH = new h(this.dPv.getPageActivity(), onClickListener);
            this.iTH.setLayoutMargin(BdListViewHelper.eDT);
            this.iTH.onChangeSkinType();
        }
        if (!this.iTH.isViewAttached()) {
            this.fml.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.dPv.getString(R.string.invite_friend_no_data_now);
            }
            this.iTH.setTitle(str);
            this.iTH.attachView(this.mRootView, true);
            this.iTH.showRefreshButton();
        }
    }

    public void btN() {
        if (this.iTH != null && this.iTH.isViewAttached()) {
            this.fml.setVisibility(0);
            this.iTH.dettachView(this.mRootView);
        }
    }
}
