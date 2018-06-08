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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private f bpl;
    private PbListView btv;
    private g emh;
    private TbPageContext<?> mContext;
    private View mHeaderView;
    private BdTypeListView mListView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.mContext = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mContext);
        this.mPullView.setTag(this.mContext.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.jD());
        this.mRootView.addView(this.mListView);
    }

    public void hq(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cl(List<com.baidu.adp.widget.ListView.a> list) {
        if (!w.z(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void bK(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void aBx() {
        aJe();
        this.btv.Ar();
    }

    public void aBy() {
        aJe();
        this.btv.setText(this.mContext.getResources().getString(d.k.network_ungeilivable));
        this.btv.As();
    }

    public void aBz() {
        aJe();
        this.btv.setText(this.mContext.getResources().getString(d.k.list_no_more));
        this.btv.As();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, d.C0141d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.btv != null) {
            this.btv.dx(d.C0141d.cp_bg_line_c);
            this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            this.btv.dy(i);
        }
        if (this.emh != null) {
            this.emh.onChangeSkinType();
        }
        if (this.bpl != null) {
            this.bpl.onChangeSkinType();
        }
    }

    public void aJd() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.btv = null;
        }
    }

    private void aJe() {
        if (this.mListView != null && this.btv == null) {
            this.btv = new PbListView(this.mContext.getPageActivity());
            this.btv.nn();
            this.mListView.setNextPage(this.btv);
        }
    }

    public void showLoadingView() {
        if (this.bpl == null) {
            this.bpl = new f(this.mContext.getPageActivity(), BdListViewHelper.aVl);
            this.bpl.onChangeSkinType();
        }
        if (!this.bpl.IP()) {
            this.mListView.setVisibility(8);
            this.bpl.d(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bpl != null && this.bpl.IP()) {
            this.mListView.setVisibility(0);
            this.bpl.P(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.emh == null) {
            this.emh = new g(this.mContext.getPageActivity(), onClickListener);
            this.emh.ff(BdListViewHelper.aVl);
            this.emh.onChangeSkinType();
        }
        if (!this.emh.IP()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.k.invite_friend_no_data_now);
            }
            this.emh.setTitle(str);
            this.emh.d(this.mRootView, true);
            this.emh.IX();
        }
    }

    public void TI() {
        if (this.emh != null && this.emh.IP()) {
            this.mListView.setVisibility(0);
            this.emh.P(this.mRootView);
        }
    }
}
