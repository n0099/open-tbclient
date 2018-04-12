package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private TbPageContext<?> adf;
    private f bha;
    private PbListView blb;
    private g dZQ;
    private View mHeaderView;
    private BdTypeListView mListView;
    private com.baidu.tbadk.core.view.f mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.adf = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.adf);
        this.mPullView.setTag(this.adf.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.gP());
        this.mRootView.addView(this.mListView);
    }

    public void hj(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cd(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.w(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void bC(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void awG() {
        aEl();
        this.blb.wR();
    }

    public void awH() {
        aEl();
        this.blb.setText(this.adf.getResources().getString(d.k.network_ungeilivable));
        this.blb.wS();
    }

    public void awI() {
        aEl();
        this.blb.setText(this.adf.getResources().getString(d.k.list_no_more));
        this.blb.wS();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mListView, d.C0126d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.blb != null) {
            this.blb.dv(d.C0126d.cp_bg_line_c);
            this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blb.dw(i);
        }
        if (this.dZQ != null) {
            this.dZQ.onChangeSkinType();
        }
        if (this.bha != null) {
            this.bha.onChangeSkinType();
        }
    }

    public void aEk() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.blb = null;
        }
    }

    private void aEl() {
        if (this.mListView != null && this.blb == null) {
            this.blb = new PbListView(this.adf.getPageActivity());
            this.blb.kA();
            this.mListView.setNextPage(this.blb);
        }
    }

    public void showLoadingView() {
        if (this.bha == null) {
            this.bha = new f(this.adf.getPageActivity(), BdListViewHelper.aNm);
            this.bha.onChangeSkinType();
        }
        if (!this.bha.Fm()) {
            this.mListView.setVisibility(8);
            this.bha.d(this.mRootView, true);
        }
    }

    public void Ou() {
        if (this.bha != null && this.bha.Fm()) {
            this.mListView.setVisibility(0);
            this.bha.P(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.dZQ == null) {
            this.dZQ = new g(this.adf.getPageActivity(), onClickListener);
            this.dZQ.fb(BdListViewHelper.aNm);
            this.dZQ.onChangeSkinType();
        }
        if (!this.dZQ.Fm()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.adf.getString(d.k.invite_friend_no_data_now);
            }
            this.dZQ.setTitle(str);
            this.dZQ.d(this.mRootView, true);
            this.dZQ.Fu();
        }
    }

    public void Qn() {
        if (this.dZQ != null && this.dZQ.Fm()) {
            this.mListView.setVisibility(0);
            this.dZQ.P(this.mRootView);
        }
    }
}
