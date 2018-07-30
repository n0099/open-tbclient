package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private f brt;
    private PbListView bvA;
    private g etW;
    private TbPageContext<?> mContext;
    private View mHeaderView;
    private BdTypeListView mListView;
    private h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.mContext = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new h(this.mContext);
        this.mPullView.setTag(this.mContext.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.jE());
        this.mRootView.addView(this.mListView);
    }

    public void hD(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cp(List<com.baidu.adp.widget.ListView.a> list) {
        if (!w.z(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void bN(List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void aCM() {
        aKM();
        this.bvA.Ax();
    }

    public void aCN() {
        aKM();
        this.bvA.setText(this.mContext.getResources().getString(d.j.network_ungeilivable));
        this.bvA.Ay();
    }

    public void aCO() {
        aKM();
        this.bvA.setText(this.mContext.getResources().getString(d.j.list_no_more));
        this.bvA.Ay();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.j(this.mListView, d.C0140d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.bvA != null) {
            this.bvA.dB(d.C0140d.cp_bg_line_c);
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            this.bvA.dC(i);
        }
        if (this.etW != null) {
            this.etW.onChangeSkinType();
        }
        if (this.brt != null) {
            this.brt.onChangeSkinType();
        }
    }

    public void aKL() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bvA = null;
        }
    }

    private void aKM() {
        if (this.mListView != null && this.bvA == null) {
            this.bvA = new PbListView(this.mContext.getPageActivity());
            this.bvA.np();
            this.mListView.setNextPage(this.bvA);
        }
    }

    public void showLoadingView() {
        if (this.brt == null) {
            this.brt = new f(this.mContext.getPageActivity(), BdListViewHelper.aWi);
            this.brt.onChangeSkinType();
        }
        if (!this.brt.Jc()) {
            this.mListView.setVisibility(8);
            this.brt.c(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.brt != null && this.brt.Jc()) {
            this.mListView.setVisibility(0);
            this.brt.Q(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.etW == null) {
            this.etW = new g(this.mContext.getPageActivity(), onClickListener);
            this.etW.fh(BdListViewHelper.aWi);
            this.etW.onChangeSkinType();
        }
        if (!this.etW.Jc()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.invite_friend_no_data_now);
            }
            this.etW.setTitle(str);
            this.etW.c(this.mRootView, true);
            this.etW.Jk();
        }
    }

    public void Uk() {
        if (this.etW != null && this.etW.Jc()) {
            this.mListView.setVisibility(0);
            this.etW.Q(this.mRootView);
        }
    }
}
