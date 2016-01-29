package com.baidu.tieba.enterForum.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    private final com.baidu.tieba.enterForum.home.e aWq;
    public BdTypeListView aXu;
    private View aXv;
    public PbListView aXw;
    private int aXx;
    private o mNoDataView;
    public t mPullView;
    private View mRootView;

    public View getView() {
        return this.mRootView;
    }

    public a(com.baidu.tieba.enterForum.home.e eVar) {
        this.aXu = null;
        this.mPullView = null;
        this.aWq = eVar;
        this.mRootView = LayoutInflater.from(eVar.getActivity()).inflate(t.h.enter_forum_square, (ViewGroup) null);
        this.aXu = (BdTypeListView) this.mRootView.findViewById(t.g.list_view);
        this.aXu.setDividerHeight(0);
        this.aXv = new View(eVar.getActivity());
        this.aXv.setLayoutParams(new AbsListView.LayoutParams(-1, k.c(eVar.getActivity(), t.e.ds50)));
        this.aXv.setVisibility(8);
        this.aXu.addFooterView(this.aXv, null, false);
        this.mPullView = new com.baidu.tbadk.core.view.t(eVar.getPageContext());
        this.mPullView.setTag(this.aWq.getUniqueId());
        this.aXu.setPullRefresh(this.mPullView);
        this.aXw = new PbListView(eVar.getActivity());
        this.aXw.ni();
        this.aXw.df(t.d.cp_bg_line_c);
        this.aXx = this.aWq.getResources().getDimensionPixelOffset(t.e.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.aXw != null) {
            this.aXw.dg(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aWq.getPageContext(), i);
        }
        ar.l(this.aXv, t.d.cp_bg_line_c);
    }

    public void ns() {
        this.aXu.ns();
    }

    public void MB() {
        this.aXu.nr();
    }

    public void hideNoDataView() {
        if (this.aXv != null) {
            this.aXv.setVisibility(0);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aXu.removeHeaderView(this.mNoDataView);
        }
    }

    public void fU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aWq.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aXx), NoDataViewFactory.d.dd(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(i));
        this.mNoDataView.onChangeSkinType(this.aWq.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.aXu.removeHeaderView(this.mNoDataView);
        this.aXu.addHeaderView(this.mNoDataView);
        if (this.aXv != null) {
            this.aXv.setVisibility(8);
        }
    }
}
