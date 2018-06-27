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
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private f bqL;
    private PbListView buU;
    private g eqd;
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
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.jD());
        this.mRootView.addView(this.mListView);
    }

    public void hA(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cp(List<com.baidu.adp.widget.ListView.a> list) {
        if (!w.A(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void bO(List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void aCd() {
        aJL();
        this.buU.AH();
    }

    public void aCe() {
        aJL();
        this.buU.setText(this.mContext.getResources().getString(d.k.network_ungeilivable));
        this.buU.AI();
    }

    public void aCf() {
        aJL();
        this.buU.setText(this.mContext.getResources().getString(d.k.list_no_more));
        this.buU.AI();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.j(this.mListView, d.C0142d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.buU != null) {
            this.buU.dy(d.C0142d.cp_bg_line_c);
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            this.buU.dz(i);
        }
        if (this.eqd != null) {
            this.eqd.onChangeSkinType();
        }
        if (this.bqL != null) {
            this.bqL.onChangeSkinType();
        }
    }

    public void aJK() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.buU = null;
        }
    }

    private void aJL() {
        if (this.mListView != null && this.buU == null) {
            this.buU = new PbListView(this.mContext.getPageActivity());
            this.buU.nn();
            this.mListView.setNextPage(this.buU);
        }
    }

    public void showLoadingView() {
        if (this.bqL == null) {
            this.bqL = new f(this.mContext.getPageActivity(), BdListViewHelper.aWg);
            this.bqL.onChangeSkinType();
        }
        if (!this.bqL.Jh()) {
            this.mListView.setVisibility(8);
            this.bqL.d(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bqL != null && this.bqL.Jh()) {
            this.mListView.setVisibility(0);
            this.bqL.Q(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eqd == null) {
            this.eqd = new g(this.mContext.getPageActivity(), onClickListener);
            this.eqd.fg(BdListViewHelper.aWg);
            this.eqd.onChangeSkinType();
        }
        if (!this.eqd.Jh()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.k.invite_friend_no_data_now);
            }
            this.eqd.setTitle(str);
            this.eqd.d(this.mRootView, true);
            this.eqd.Jp();
        }
    }

    public void Uc() {
        if (this.eqd != null && this.eqd.Jh()) {
            this.mListView.setVisibility(0);
            this.eqd.Q(this.mRootView);
        }
    }
}
