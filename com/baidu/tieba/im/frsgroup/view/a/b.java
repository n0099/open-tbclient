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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes23.dex */
public class b {
    private TbPageContext<?> eIc;
    private BdTypeListView gih;
    private PbListView gjo;
    private g gso;
    private h kgU;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.eIc = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gih = new BdTypeListView(tbPageContext.getPageActivity());
        this.gih.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.gih.setSelector(17170445);
        this.gih.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.eIc);
        this.mPullView.setTag(this.eIc.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.gih.setOnSrollToBottomListener(cVar);
        this.gih.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.gih, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.gih);
    }

    public void rY(boolean z) {
        if (this.mHeaderView != null && this.gih != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void en(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.gih.addAdapters(list);
        }
    }

    public void dy(List<q> list) {
        if (list != null) {
            this.gih.setData(list);
        }
    }

    public void completePullRefresh() {
        this.gih.completePullRefreshPostDelayed(0L);
    }

    public void cHV() {
        cSA();
        this.gjo.startLoadData();
    }

    public void cHW() {
        cSA();
        this.gjo.setText(this.eIc.getResources().getString(R.string.network_ungeilivable));
        this.gjo.endLoadData();
    }

    public void cHX() {
        cSA();
        this.gjo.setText(this.eIc.getResources().getString(R.string.list_no_more));
        this.gjo.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gih, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjo != null) {
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.changeSkin(i);
        }
        if (this.kgU != null) {
            this.kgU.onChangeSkinType();
        }
        if (this.gso != null) {
            this.gso.onChangeSkinType();
        }
    }

    public void cSz() {
        if (this.gih != null) {
            this.gih.setNextPage(null);
            this.gjo = null;
        }
    }

    private void cSA() {
        if (this.gih != null && this.gjo == null) {
            this.gjo = new PbListView(this.eIc.getPageActivity());
            this.gjo.createView();
            this.gih.setNextPage(this.gjo);
        }
    }

    public void showLoadingView() {
        if (this.gso == null) {
            this.gso = new g(this.eIc.getPageActivity(), BdListViewHelper.fys);
            this.gso.onChangeSkinType();
        }
        if (!this.gso.isViewAttached()) {
            this.gih.setVisibility(8);
            this.gso.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null && this.gso.isViewAttached()) {
            this.gih.setVisibility(0);
            this.gso.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.kgU == null) {
            this.kgU = new h(this.eIc.getPageActivity(), onClickListener);
            this.kgU.setLayoutMargin(BdListViewHelper.fys);
            this.kgU.onChangeSkinType();
        }
        if (!this.kgU.isViewAttached()) {
            this.gih.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.eIc.getString(R.string.invite_friend_no_data_now);
            }
            this.kgU.setTitle(str);
            this.kgU.attachView(this.mRootView, true);
            this.kgU.showRefreshButton();
        }
    }

    public void Wk() {
        if (this.kgU != null && this.kgU.isViewAttached()) {
            this.gih.setVisibility(0);
            this.kgU.dettachView(this.mRootView);
        }
    }
}
