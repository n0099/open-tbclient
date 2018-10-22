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
    private f bFV;
    private PbListView bJY;
    private g eIW;
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
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.kX());
        this.mRootView.addView(this.mListView);
    }

    public void it(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cF(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.J(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void ce(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void aIo() {
        aQn();
        this.bJY.DO();
    }

    public void aIp() {
        aQn();
        this.bJY.setText(this.mContext.getResources().getString(e.j.network_ungeilivable));
        this.bJY.DP();
    }

    public void aIq() {
        aQn();
        this.bJY.setText(this.mContext.getResources().getString(e.j.list_no_more));
        this.bJY.DP();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.bJY != null) {
            this.bJY.dV(e.d.cp_bg_line_c);
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bJY.dW(i);
        }
        if (this.eIW != null) {
            this.eIW.onChangeSkinType();
        }
        if (this.bFV != null) {
            this.bFV.onChangeSkinType();
        }
    }

    public void aQm() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bJY = null;
        }
    }

    private void aQn() {
        if (this.mListView != null && this.bJY == null) {
            this.bJY = new PbListView(this.mContext.getPageActivity());
            this.bJY.oG();
            this.mListView.setNextPage(this.bJY);
        }
    }

    public void showLoadingView() {
        if (this.bFV == null) {
            this.bFV = new f(this.mContext.getPageActivity(), BdListViewHelper.bdY);
            this.bFV.onChangeSkinType();
        }
        if (!this.bFV.Mq()) {
            this.mListView.setVisibility(8);
            this.bFV.c(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bFV != null && this.bFV.Mq()) {
            this.mListView.setVisibility(0);
            this.bFV.ad(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eIW == null) {
            this.eIW = new g(this.mContext.getPageActivity(), onClickListener);
            this.eIW.fB(BdListViewHelper.bdY);
            this.eIW.onChangeSkinType();
        }
        if (!this.eIW.Mq()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.invite_friend_no_data_now);
            }
            this.eIW.setTitle(str);
            this.eIW.c(this.mRootView, true);
            this.eIW.My();
        }
    }

    public void ZI() {
        if (this.eIW != null && this.eIW.Mq()) {
            this.mListView.setVisibility(0);
            this.eIW.ad(this.mRootView);
        }
    }
}
