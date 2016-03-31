package com.baidu.tieba.enterForum.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    private final com.baidu.tieba.enterForum.home.e baZ;
    public BdTypeListView bcd;
    private View bce;
    public PbListView bcf;
    private int bcg;
    private p mNoDataView;
    public u mPullView;
    private View mRootView;

    public View getView() {
        return this.mRootView;
    }

    public a(com.baidu.tieba.enterForum.home.e eVar) {
        this.bcd = null;
        this.mPullView = null;
        this.baZ = eVar;
        this.mRootView = LayoutInflater.from(eVar.getActivity()).inflate(t.h.enter_forum_square, (ViewGroup) null);
        this.bcd = (BdTypeListView) this.mRootView.findViewById(t.g.list_view);
        this.bcd.setDividerHeight(0);
        this.bce = new View(eVar.getActivity());
        this.bce.setLayoutParams(new AbsListView.LayoutParams(-1, k.c(eVar.getActivity(), t.e.ds50)));
        this.bce.setVisibility(8);
        this.bcd.addFooterView(this.bce, null, false);
        this.mPullView = new u(eVar.getPageContext());
        this.mPullView.setTag(this.baZ.getUniqueId());
        this.bcd.setPullRefresh(this.mPullView);
        this.bcf = new PbListView(eVar.getActivity());
        this.bcf.mZ();
        this.bcf.di(t.d.cp_bg_line_c);
        this.bcg = this.baZ.getResources().getDimensionPixelOffset(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.bcf != null) {
            this.bcf.dj(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.baZ.getPageContext(), i);
        }
        at.l(this.bce, t.d.cp_bg_line_c);
    }

    public void nk() {
        this.bcd.nk();
    }

    public void Op() {
        this.bcd.nj();
    }

    public void hideNoDataView() {
        if (this.bce != null) {
            this.bce.setVisibility(0);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bcd.removeHeaderView(this.mNoDataView);
        }
    }

    public void gk(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.baZ.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.bcg), NoDataViewFactory.d.dg(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(i));
        this.mNoDataView.onChangeSkinType(this.baZ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bcd.removeHeaderView(this.mNoDataView);
        this.bcd.addHeaderView(this.mNoDataView);
        if (this.bce != null) {
            this.bce.setVisibility(8);
        }
    }
}
