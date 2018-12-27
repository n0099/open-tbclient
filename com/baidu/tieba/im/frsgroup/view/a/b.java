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
    private f bKy;
    private PbListView bOB;
    private g eTU;
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

    public void iI(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cI(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.I(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void ch(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void aKs() {
        aSp();
        this.bOB.Fc();
    }

    public void aKt() {
        aSp();
        this.bOB.setText(this.mContext.getResources().getString(e.j.network_ungeilivable));
        this.bOB.Fd();
    }

    public void aKu() {
        aSp();
        this.bOB.setText(this.mContext.getResources().getString(e.j.list_no_more));
        this.bOB.Fd();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.bOB != null) {
            this.bOB.ex(e.d.cp_bg_line_c);
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOB.ey(i);
        }
        if (this.eTU != null) {
            this.eTU.onChangeSkinType();
        }
        if (this.bKy != null) {
            this.bKy.onChangeSkinType();
        }
    }

    public void aSo() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bOB = null;
        }
    }

    private void aSp() {
        if (this.mListView != null && this.bOB == null) {
            this.bOB = new PbListView(this.mContext.getPageActivity());
            this.bOB.oD();
            this.mListView.setNextPage(this.bOB);
        }
    }

    public void showLoadingView() {
        if (this.bKy == null) {
            this.bKy = new f(this.mContext.getPageActivity(), BdListViewHelper.bir);
            this.bKy.onChangeSkinType();
        }
        if (!this.bKy.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.bKy.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bKy != null && this.bKy.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.bKy.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eTU == null) {
            this.eTU = new g(this.mContext.getPageActivity(), onClickListener);
            this.eTU.ge(BdListViewHelper.bir);
            this.eTU.onChangeSkinType();
        }
        if (!this.eTU.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.invite_friend_no_data_now);
            }
            this.eTU.setTitle(str);
            this.eTU.attachView(this.mRootView, true);
            this.eTU.NM();
        }
    }

    public void aba() {
        if (this.eTU != null && this.eTU.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.eTU.dettachView(this.mRootView);
        }
    }
}
