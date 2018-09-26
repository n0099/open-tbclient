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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private PbListView bBr;
    private f bxm;
    private g eBl;
    private TbPageContext<?> mContext;
    private View mHeaderView;
    private BdTypeListView mListView;
    private k mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.mContext = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new k(this.mContext);
        this.mPullView.setTag(this.mContext.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.kK());
        this.mRootView.addView(this.mListView);
    }

    public void ib(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cq(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.z(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void bO(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void aEW() {
        aMY();
        this.bBr.BI();
    }

    public void aEX() {
        aMY();
        this.bBr.setText(this.mContext.getResources().getString(e.j.network_ungeilivable));
        this.bBr.BJ();
    }

    public void aEY() {
        aMY();
        this.bBr.setText(this.mContext.getResources().getString(e.j.list_no_more));
        this.bBr.BJ();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.bBr != null) {
            this.bBr.dL(e.d.cp_bg_line_c);
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bBr.dM(i);
        }
        if (this.eBl != null) {
            this.eBl.onChangeSkinType();
        }
        if (this.bxm != null) {
            this.bxm.onChangeSkinType();
        }
    }

    public void aMX() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bBr = null;
        }
    }

    private void aMY() {
        if (this.mListView != null && this.bBr == null) {
            this.bBr = new PbListView(this.mContext.getPageActivity());
            this.bBr.ov();
            this.mListView.setNextPage(this.bBr);
        }
    }

    public void showLoadingView() {
        if (this.bxm == null) {
            this.bxm = new f(this.mContext.getPageActivity(), BdListViewHelper.aZy);
            this.bxm.onChangeSkinType();
        }
        if (!this.bxm.Ks()) {
            this.mListView.setVisibility(8);
            this.bxm.c(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bxm != null && this.bxm.Ks()) {
            this.mListView.setVisibility(0);
            this.bxm.ad(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eBl == null) {
            this.eBl = new g(this.mContext.getPageActivity(), onClickListener);
            this.eBl.fs(BdListViewHelper.aZy);
            this.eBl.onChangeSkinType();
        }
        if (!this.eBl.Ks()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.invite_friend_no_data_now);
            }
            this.eBl.setTitle(str);
            this.eBl.c(this.mRootView, true);
            this.eBl.KA();
        }
    }

    public void Wa() {
        if (this.eBl != null && this.eBl.Ks()) {
            this.mListView.setVisibility(0);
            this.eBl.ad(this.mRootView);
        }
    }
}
