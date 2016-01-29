package com.baidu.tieba.frs.collect;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.aa;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    private PbListView aXw;
    private NoNetworkView.a bdG;
    private c.b bjH;
    private MyCollectFrsActivity bmb;
    private View bna;
    private View bnb;
    private BdTypeListView bnc;
    private NoNetworkView bnd;
    private fg bne;
    private NavigationBar mNavigationBar;
    private t mPullView;
    private boolean mHasMore = true;
    private int bjN = 0;
    private com.baidu.tbadk.core.dialog.c bjE = null;
    private o mNoDataView = null;
    private View.OnClickListener Ss = null;

    public l(MyCollectFrsActivity myCollectFrsActivity) {
        this.bmb = myCollectFrsActivity;
        qD();
    }

    public void s(View.OnClickListener onClickListener) {
        this.Ss = onClickListener;
    }

    private void qD() {
        this.bna = this.bmb.findViewById(t.g.collect_frs);
        this.mNavigationBar = (NavigationBar) this.bmb.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(t.j.store_card_of_the_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bnb = this.bmb.findViewById(t.g.collect_frs_list_content);
        this.bnc = (BdTypeListView) this.bmb.findViewById(t.g.collect_frs_list_view);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.bmb.getPageContext());
        this.bnc.setDivider(null);
        this.bnc.setPullRefresh(this.mPullView);
        this.bnc.setDividerHeight(0);
        this.bnc.setRecyclerListener(new m(this));
        this.aXw = new PbListView(this.bmb.getPageContext().getPageActivity());
        this.aXw.ni();
        this.aXw.df(t.d.cp_bg_line_c);
        this.bnc.setOnSrollToBottomListener(this.bmb);
        this.mNavigationBar.setOnTouchListener(new aa(new n(this)));
        this.bne = new fg(this.bmb, this.bnc, ax.wg().wi());
        this.bnd = (NoNetworkView) this.bmb.findViewById(t.g.view_no_network);
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void a(v vVar) {
        this.bne.a(vVar);
    }

    public void a(w wVar) {
        this.bne.a(wVar);
    }

    public void onDestroy() {
        this.bne.onDestory();
        this.bnc.setOnSrollToBottomListener(null);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.bne != null) {
            this.bne.notifyDataSetChanged();
        }
        this.bmb.getLayoutMode().x(this.bna);
        this.mNavigationBar.onChangeSkinType(this.bmb.getPageContext(), i);
        this.bnd.onChangeSkinType(this.bmb.getPageContext(), i);
    }

    public void ns() {
        this.bnc.ns();
    }

    public fg QO() {
        return this.bne;
    }

    public View getRootView() {
        return this.bna;
    }

    public void Qn() {
        this.mHasMore = true;
        this.bnc.setNextPage(this.aXw);
        this.aXw.xb();
    }

    public void Qo() {
        this.mHasMore = false;
        if (this.bjN > 0) {
            this.aXw.dh(this.bjN);
        }
        this.bnc.setNextPage(this.aXw);
        this.aXw.xc();
        this.aXw.setText(this.bmb.getResources().getString(t.j.list_no_more));
    }

    public void Qp() {
        this.mHasMore = false;
        this.bnc.setNextPage(null);
        this.aXw.xd();
    }

    public void gy(int i) {
        this.bjN = i;
    }

    public void PW() {
        if (this.bne != null) {
            this.bne.notifyDataSetChanged();
        }
    }

    public void a(c.b bVar) {
        this.bjH = bVar;
    }

    public void a(ah ahVar, boolean z) {
        String string = this.bmb.getPageContext().getPageActivity().getString(t.j.view);
        String string2 = this.bmb.getPageContext().getPageActivity().getString(t.j.view_host);
        String string3 = this.bmb.getPageContext().getPageActivity().getString(t.j.view_reverse);
        if (this.bjE == null) {
            this.bjE = new com.baidu.tbadk.core.dialog.c(this.bmb.getPageContext().getPageActivity());
        }
        this.bjE.cb(t.j.operation);
        if (z) {
            this.bjE.a(new String[]{string, string3}, this.bjH);
        } else {
            this.bjE.a(new String[]{string, string2, string3}, this.bjH);
        }
        this.bjE.d(this.bmb.getPageContext());
    }

    public void PU() {
        if (this.bjE != null) {
            this.bjE.un();
        }
    }

    public void f(NoNetworkView.a aVar) {
        this.bdG = aVar;
        if (this.bnd != null) {
            this.bnd.a(this.bdG);
        }
    }

    public void release() {
        if (this.bnd != null && this.bdG != null) {
            this.bnd.b(this.bdG);
        }
    }

    public BdListView KM() {
        return this.bnc;
    }

    public int Qc() {
        return 0;
    }

    public void nr() {
        this.bnc.nr();
    }

    public void a(ArrayList<u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            dd ddVar = new dd();
            arrayList = new ArrayList<>();
            arrayList.add(ddVar);
        }
        this.bne.a(arrayList, oVar);
    }

    public void hw(String str) {
        a(NoDataViewFactory.d.ac(str, this.bmb.getPageContext().getString(t.j.refresh_view_title_text)));
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bmb.getPageContext().getString(t.j.refresh_view_button_text), this.Ss));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.bmb.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.bnb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds140)), dVar, a, false);
        }
        this.bnc.setVisibility(8);
        ar.l(this.mNoDataView, t.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.bmb.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bnc.setVisibility(0);
    }
}
