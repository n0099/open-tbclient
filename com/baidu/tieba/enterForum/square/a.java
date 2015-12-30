package com.baidu.tieba.enterForum.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    private final com.baidu.tieba.enterForum.home.e aUj;
    public BdTypeListView aVi;
    public PbListView aVj;
    private int aVk;
    private View mFooterView;
    private o mNoDataView;
    public t mPullView;
    private View mRootView;

    public View getView() {
        return this.mRootView;
    }

    public a(com.baidu.tieba.enterForum.home.e eVar) {
        this.aVi = null;
        this.mPullView = null;
        this.aUj = eVar;
        this.mRootView = LayoutInflater.from(eVar.getActivity()).inflate(n.h.enter_forum_square, (ViewGroup) null);
        this.aVi = (BdTypeListView) this.mRootView.findViewById(n.g.list_view);
        this.aVi.setDividerHeight(0);
        this.mFooterView = new View(eVar.getActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, k.d(eVar.getActivity(), n.e.ds50)));
        this.mFooterView.setVisibility(8);
        this.aVi.addFooterView(this.mFooterView, null, false);
        this.mPullView = new t(eVar.getPageContext());
        this.mPullView.setTag(this.aUj.getUniqueId());
        this.aVi.setPullRefresh(this.mPullView);
        this.aVj = new PbListView(eVar.getActivity());
        this.aVj.mT();
        this.aVj.cO(n.d.cp_bg_line_c);
        this.aVk = this.aUj.getResources().getDimensionPixelOffset(n.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.aVj != null) {
            this.aVj.cP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aUj.getPageContext(), i);
        }
        as.j(this.mFooterView, n.d.cp_bg_line_c);
    }

    public void nb() {
        this.aVi.nb();
    }

    public void KK() {
        this.aVi.completePullRefresh();
    }

    public void hideNoDataView() {
        if (this.mFooterView != null) {
            this.mFooterView.setVisibility(0);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aVi.removeHeaderView(this.mNoDataView);
        }
    }

    public void fv(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aUj.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aVk), NoDataViewFactory.d.cM(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(i));
        this.mNoDataView.onChangeSkinType(this.aUj.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.aVi.removeHeaderView(this.mNoDataView);
        this.aVi.addHeaderView(this.mNoDataView);
        if (this.mFooterView != null) {
            this.mFooterView.setVisibility(8);
        }
    }
}
