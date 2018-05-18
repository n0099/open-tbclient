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
    private f bhf;
    private PbListView blq;
    private g eaU;
    private TbPageContext<?> mContext;
    private View mHeaderView;
    private BdTypeListView mListView;
    private com.baidu.tbadk.core.view.f mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.mContext = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.mContext);
        this.mPullView.setTag(this.mContext.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.gP());
        this.mRootView.addView(this.mListView);
    }

    public void hk(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cg(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.w(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void bF(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void awF() {
        aEj();
        this.blq.wQ();
    }

    public void awG() {
        aEj();
        this.blq.setText(this.mContext.getResources().getString(d.k.network_ungeilivable));
        this.blq.wR();
    }

    public void awH() {
        aEj();
        this.blq.setText(this.mContext.getResources().getString(d.k.list_no_more));
        this.blq.wR();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mListView, d.C0126d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.blq != null) {
            this.blq.dv(d.C0126d.cp_bg_line_c);
            this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blq.dw(i);
        }
        if (this.eaU != null) {
            this.eaU.onChangeSkinType();
        }
        if (this.bhf != null) {
            this.bhf.onChangeSkinType();
        }
    }

    public void aEi() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.blq = null;
        }
    }

    private void aEj() {
        if (this.mListView != null && this.blq == null) {
            this.blq = new PbListView(this.mContext.getPageActivity());
            this.blq.kz();
            this.mListView.setNextPage(this.blq);
        }
    }

    public void showLoadingView() {
        if (this.bhf == null) {
            this.bhf = new f(this.mContext.getPageActivity(), BdListViewHelper.aNn);
            this.bhf.onChangeSkinType();
        }
        if (!this.bhf.Fk()) {
            this.mListView.setVisibility(8);
            this.bhf.d(this.mRootView, true);
        }
    }

    public void Os() {
        if (this.bhf != null && this.bhf.Fk()) {
            this.mListView.setVisibility(0);
            this.bhf.P(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eaU == null) {
            this.eaU = new g(this.mContext.getPageActivity(), onClickListener);
            this.eaU.fb(BdListViewHelper.aNn);
            this.eaU.onChangeSkinType();
        }
        if (!this.eaU.Fk()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.k.invite_friend_no_data_now);
            }
            this.eaU.setTitle(str);
            this.eaU.d(this.mRootView, true);
            this.eaU.Fs();
        }
    }

    public void Qk() {
        if (this.eaU != null && this.eaU.Fk()) {
            this.mListView.setVisibility(0);
            this.eaU.P(this.mRootView);
        }
    }
}
