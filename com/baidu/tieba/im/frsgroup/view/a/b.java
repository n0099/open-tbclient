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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private f brv;
    private PbListView bvC;
    private g etS;
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

    public void aCJ() {
        aKJ();
        this.bvC.Av();
    }

    public void aCK() {
        aKJ();
        this.bvC.setText(this.mContext.getResources().getString(f.j.network_ungeilivable));
        this.bvC.Aw();
    }

    public void aCL() {
        aKJ();
        this.bvC.setText(this.mContext.getResources().getString(f.j.list_no_more));
        this.bvC.Aw();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.j(this.mListView, f.d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.bvC != null) {
            this.bvC.dA(f.d.cp_bg_line_c);
            this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
            this.bvC.dB(i);
        }
        if (this.etS != null) {
            this.etS.onChangeSkinType();
        }
        if (this.brv != null) {
            this.brv.onChangeSkinType();
        }
    }

    public void aKI() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.bvC = null;
        }
    }

    private void aKJ() {
        if (this.mListView != null && this.bvC == null) {
            this.bvC = new PbListView(this.mContext.getPageActivity());
            this.bvC.np();
            this.mListView.setNextPage(this.bvC);
        }
    }

    public void showLoadingView() {
        if (this.brv == null) {
            this.brv = new com.baidu.tbadk.k.f(this.mContext.getPageActivity(), BdListViewHelper.aWi);
            this.brv.onChangeSkinType();
        }
        if (!this.brv.Jc()) {
            this.mListView.setVisibility(8);
            this.brv.c(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.brv != null && this.brv.Jc()) {
            this.mListView.setVisibility(0);
            this.brv.Q(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.etS == null) {
            this.etS = new g(this.mContext.getPageActivity(), onClickListener);
            this.etS.fg(BdListViewHelper.aWi);
            this.etS.onChangeSkinType();
        }
        if (!this.etS.Jc()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(f.j.invite_friend_no_data_now);
            }
            this.etS.setTitle(str);
            this.etS.c(this.mRootView, true);
            this.etS.Jk();
        }
    }

    public void Un() {
        if (this.etS != null && this.etS.Jc()) {
            this.mListView.setVisibility(0);
            this.etS.Q(this.mRootView);
        }
    }
}
