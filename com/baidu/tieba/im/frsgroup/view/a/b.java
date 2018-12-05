package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
    private f bKv;
    private PbListView bOy;
    private g eRd;
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
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.kV());
        this.mRootView.addView(this.mListView);
    }

    public void iF(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cH(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.I(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void cg(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void aJD() {
        aRC();
        this.bOy.Fc();
    }

    public void aJE() {
        aRC();
        this.bOy.setText(this.mContext.getResources().getString(e.j.network_ungeilivable));
        this.bOy.Fd();
    }

    public void aJF() {
        aRC();
        this.bOy.setText(this.mContext.getResources().getString(e.j.list_no_more));
        this.bOy.Fd();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.bOy != null) {
            this.bOy.ex(e.d.cp_bg_line_c);
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOy.ey(i);
        }
        if (this.eRd != null) {
            this.eRd.onChangeSkinType();
        }
        if (this.bKv != null) {
            this.bKv.onChangeSkinType();
        }
    }

    public void aRB() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bOy = null;
        }
    }

    private void aRC() {
        if (this.mListView != null && this.bOy == null) {
            this.bOy = new PbListView(this.mContext.getPageActivity());
            this.bOy.oD();
            this.mListView.setNextPage(this.bOy);
        }
    }

    public void showLoadingView() {
        if (this.bKv == null) {
            this.bKv = new f(this.mContext.getPageActivity(), BdListViewHelper.bio);
            this.bKv.onChangeSkinType();
        }
        if (!this.bKv.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.bKv.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bKv != null && this.bKv.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.bKv.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eRd == null) {
            this.eRd = new g(this.mContext.getPageActivity(), onClickListener);
            this.eRd.gd(BdListViewHelper.bio);
            this.eRd.onChangeSkinType();
        }
        if (!this.eRd.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.invite_friend_no_data_now);
            }
            this.eRd.setTitle(str);
            this.eRd.attachView(this.mRootView, true);
            this.eRd.NL();
        }
    }

    public void aaY() {
        if (this.eRd != null && this.eRd.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.eRd.dettachView(this.mRootView);
        }
    }
}
