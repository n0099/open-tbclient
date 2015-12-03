package com.baidu.tieba.frs.collect;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    private NoNetworkView aNL;
    private PbListView aRt;
    private NoNetworkView.a aXw;
    private c.b bcU;
    private MyCollectFrsActivity bfn;
    private View bgm;
    private View bgn;
    private BdTypeListView bgo;
    private ev bgp;
    private NavigationBar mNavigationBar;
    private s mPullView;
    private boolean mHasMore = true;
    private int bcZ = 0;
    private com.baidu.tbadk.core.dialog.c bcR = null;
    private com.baidu.tbadk.core.view.n mNoDataView = null;
    private View.OnClickListener Sy = null;

    public l(MyCollectFrsActivity myCollectFrsActivity) {
        this.bfn = myCollectFrsActivity;
        initUI();
    }

    public void n(View.OnClickListener onClickListener) {
        this.Sy = onClickListener;
    }

    private void initUI() {
        this.bgm = this.bfn.findViewById(n.f.collect_frs);
        this.mNavigationBar = (NavigationBar) this.bfn.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(n.i.store_card_of_the_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bgn = this.bfn.findViewById(n.f.collect_frs_list_content);
        this.bgo = (BdTypeListView) this.bfn.findViewById(n.f.collect_frs_list_view);
        this.mPullView = new s(this.bfn.getPageContext());
        this.bgo.setDivider(null);
        this.bgo.setPullRefresh(this.mPullView);
        this.bgo.setDividerHeight(0);
        this.bgo.setRecyclerListener(new m(this));
        this.aRt = new PbListView(this.bfn.getPageContext().getPageActivity());
        this.aRt.nv();
        this.aRt.cU(n.c.cp_bg_line_c);
        this.bgo.setOnSrollToBottomListener(this.bfn);
        this.mNavigationBar.setOnTouchListener(new ab(new n(this)));
        this.bgp = new ev(this.bfn, this.bgo, ay.vq().vs());
        this.aNL = (NoNetworkView) this.bfn.findViewById(n.f.view_no_network);
    }

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void a(v vVar) {
        this.bgp.a(vVar);
    }

    public void a(w wVar) {
        this.bgp.a(wVar);
    }

    public void onDestroy() {
        this.bgp.onDestory();
        this.bgo.setOnSrollToBottomListener(null);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.bgp != null) {
            this.bgp.notifyDataSetChanged();
        }
        this.bfn.getLayoutMode().k(this.bgm);
        this.mNavigationBar.onChangeSkinType(this.bfn.getPageContext(), i);
        this.aNL.onChangeSkinType(this.bfn.getPageContext(), i);
    }

    public void nD() {
        this.bgo.nD();
    }

    public ev Ot() {
        return this.bgp;
    }

    public View getRootView() {
        return this.bgm;
    }

    public void NR() {
        this.mHasMore = true;
        this.bgo.setNextPage(this.aRt);
        this.aRt.startLoadData();
    }

    public void NS() {
        this.mHasMore = false;
        if (this.bcZ > 0) {
            this.aRt.cW(this.bcZ);
        }
        this.bgo.setNextPage(this.aRt);
        this.aRt.wf();
        this.aRt.setText(this.bfn.getResources().getString(n.i.list_no_more));
    }

    public void NT() {
        this.mHasMore = false;
        this.bgo.setNextPage(null);
        this.aRt.wg();
    }

    public void gg(int i) {
        this.bcZ = i;
    }

    public void ND() {
        if (this.bgp != null) {
            this.bgp.notifyDataSetChanged();
        }
    }

    public void c(c.b bVar) {
        this.bcU = bVar;
    }

    public void a(z zVar, boolean z) {
        String string = this.bfn.getPageContext().getPageActivity().getString(n.i.view);
        String string2 = this.bfn.getPageContext().getPageActivity().getString(n.i.view_host);
        String string3 = this.bfn.getPageContext().getPageActivity().getString(n.i.view_reverse);
        if (this.bcR == null) {
            this.bcR = new com.baidu.tbadk.core.dialog.c(this.bfn.getPageContext().getPageActivity());
        }
        this.bcR.bQ(n.i.operation);
        if (z) {
            this.bcR.a(new String[]{string, string3}, this.bcU);
        } else {
            this.bcR.a(new String[]{string, string2, string3}, this.bcU);
        }
        this.bcR.d(this.bfn.getPageContext());
    }

    public void NA() {
        if (this.bcR != null) {
            this.bcR.tz();
        }
    }

    public void f(NoNetworkView.a aVar) {
        this.aXw = aVar;
        if (this.aNL != null) {
            this.aNL.a(this.aXw);
        }
    }

    public void release() {
        if (this.aNL != null && this.aXw != null) {
            this.aNL.b(this.aXw);
        }
    }

    public BdListView getListView() {
        return this.bgo;
    }

    public int NJ() {
        return 0;
    }

    public void completePullRefresh() {
        this.bgo.completePullRefresh();
    }

    public void a(ArrayList<u> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            ct ctVar = new ct();
            arrayList = new ArrayList<>();
            arrayList.add(ctVar);
        }
        this.bgp.a(arrayList, pVar);
    }

    public void hk(String str) {
        a(NoDataViewFactory.d.ad(str, this.bfn.getPageContext().getString(n.i.refresh_view_title_text)));
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bfn.getPageContext().getString(n.i.refresh_view_button_text), this.Sy));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.bfn.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.bgn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(pageActivity, n.d.ds140)), dVar, a, false);
        }
        this.bgo.setVisibility(8);
        as.j(this.mNoDataView, n.c.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.bfn.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bgo.setVisibility(0);
    }
}
