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
import com.baidu.tbadk.core.view.n;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    private final com.baidu.tieba.enterForum.home.e aRr;
    public BdTypeListView aRs;
    public PbListView aRt;
    private int aRu;
    private View mFooterView;
    private n mNoDataView;
    public s mPullView;
    private View mRootView;

    public View getView() {
        return this.mRootView;
    }

    public a(com.baidu.tieba.enterForum.home.e eVar) {
        this.aRs = null;
        this.mPullView = null;
        this.aRr = eVar;
        this.mRootView = LayoutInflater.from(eVar.getActivity()).inflate(n.g.enter_forum_square, (ViewGroup) null);
        this.aRs = (BdTypeListView) this.mRootView.findViewById(n.f.list_view);
        this.aRs.setDividerHeight(0);
        this.mFooterView = new View(eVar.getActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, k.d(eVar.getActivity(), n.d.ds50)));
        this.mFooterView.setVisibility(8);
        this.aRs.addFooterView(this.mFooterView, null, false);
        this.mPullView = new s(eVar.getPageContext());
        this.aRs.setPullRefresh(this.mPullView);
        this.aRt = new PbListView(eVar.getActivity());
        this.aRt.nv();
        this.aRt.cU(n.c.cp_bg_line_c);
        this.aRu = this.aRr.getResources().getDimensionPixelOffset(n.d.ds120);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.aRt != null) {
            this.aRt.cV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aRr.getPageContext(), i);
        }
        as.j(this.mFooterView, n.c.cp_bg_line_c);
    }

    public void nD() {
        this.aRs.nD();
    }

    public void Kr() {
        this.aRs.completePullRefresh();
    }

    public void hideNoDataView() {
        if (this.mFooterView != null) {
            this.mFooterView.setVisibility(0);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aRs.removeHeaderView(this.mNoDataView);
        }
    }

    public void fA(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aRr.getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, this.aRu), NoDataViewFactory.d.cS(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(i));
        this.mNoDataView.onChangeSkinType(this.aRr.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.aRs.removeHeaderView(this.mNoDataView);
        this.aRs.addHeaderView(this.mNoDataView);
        if (this.mFooterView != null) {
            this.mFooterView.setVisibility(8);
        }
    }
}
