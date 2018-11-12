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
    private f bGG;
    private PbListView bKJ;
    private g eKo;
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

    public void iC(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cD(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.I(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void cc(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void aHM() {
        aPK();
        this.bKJ.DY();
    }

    public void aHN() {
        aPK();
        this.bKJ.setText(this.mContext.getResources().getString(e.j.network_ungeilivable));
        this.bKJ.DZ();
    }

    public void aHO() {
        aPK();
        this.bKJ.setText(this.mContext.getResources().getString(e.j.list_no_more));
        this.bKJ.DZ();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.j(this.mListView, e.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.bKJ != null) {
            this.bKJ.ej(e.d.cp_bg_line_c);
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bKJ.ek(i);
        }
        if (this.eKo != null) {
            this.eKo.onChangeSkinType();
        }
        if (this.bGG != null) {
            this.bGG.onChangeSkinType();
        }
    }

    public void aPJ() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bKJ = null;
        }
    }

    private void aPK() {
        if (this.mListView != null && this.bKJ == null) {
            this.bKJ = new PbListView(this.mContext.getPageActivity());
            this.bKJ.oE();
            this.mListView.setNextPage(this.bKJ);
        }
    }

    public void showLoadingView() {
        if (this.bGG == null) {
            this.bGG = new f(this.mContext.getPageActivity(), BdListViewHelper.beN);
            this.bGG.onChangeSkinType();
        }
        if (!this.bGG.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.bGG.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.bGG != null && this.bGG.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.bGG.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eKo == null) {
            this.eKo = new g(this.mContext.getPageActivity(), onClickListener);
            this.eKo.fP(BdListViewHelper.beN);
            this.eKo.onChangeSkinType();
        }
        if (!this.eKo.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.invite_friend_no_data_now);
            }
            this.eKo.setTitle(str);
            this.eKo.attachView(this.mRootView, true);
            this.eKo.MH();
        }
    }

    public void ZS() {
        if (this.eKo != null && this.eKo.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.eKo.dettachView(this.mRootView);
        }
    }
}
