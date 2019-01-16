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
    private f bLl;
    private PbListView bPm;
    private g eUH;
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

    public void cJ(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.I(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void ci(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void aKQ() {
        aSP();
        this.bPm.Fp();
    }

    public void aKR() {
        aSP();
        this.bPm.setText(this.mContext.getResources().getString(e.j.network_ungeilivable));
        this.bPm.Fq();
    }

    public void aKS() {
        aSP();
        this.bPm.setText(this.mContext.getResources().getString(e.j.list_no_more));
        this.bPm.Fq();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.bPm != null) {
            this.bPm.ex(e.d.cp_bg_line_c);
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPm.ey(i);
        }
        if (this.eUH != null) {
            this.eUH.onChangeSkinType();
        }
        if (this.bLl != null) {
            this.bLl.onChangeSkinType();
        }
    }

    public void aSO() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bPm = null;
        }
    }

    private void aSP() {
        if (this.mListView != null && this.bPm == null) {
            this.bPm = new PbListView(this.mContext.getPageActivity());
            this.bPm.oH();
            this.mListView.setNextPage(this.bPm);
        }
    }

    public void showLoadingView() {
        if (this.bLl == null) {
            this.bLl = new f(this.mContext.getPageActivity(), BdListViewHelper.bja);
            this.bLl.onChangeSkinType();
        }
        if (!this.bLl.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.bLl.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bLl != null && this.bLl.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.bLl.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eUH == null) {
            this.eUH = new g(this.mContext.getPageActivity(), onClickListener);
            this.eUH.ge(BdListViewHelper.bja);
            this.eUH.onChangeSkinType();
        }
        if (!this.eUH.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.invite_friend_no_data_now);
            }
            this.eUH.setTitle(str);
            this.eUH.attachView(this.mRootView, true);
            this.eUH.Od();
        }
    }

    public void abx() {
        if (this.eUH != null && this.eUH.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.eUH.dettachView(this.mRootView);
        }
    }
}
