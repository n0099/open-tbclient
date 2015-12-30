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
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    private NoNetworkView aRD;
    private PbListView aVj;
    private NoNetworkView.a bbw;
    private c.b bgU;
    private MyCollectFrsActivity bjg;
    private View bke;
    private View bkf;
    private BdTypeListView bkg;
    private ew bkh;
    private NavigationBar mNavigationBar;
    private t mPullView;
    private boolean mHasMore = true;
    private int bgZ = 0;
    private com.baidu.tbadk.core.dialog.c bgR = null;
    private o mNoDataView = null;
    private View.OnClickListener SY = null;

    public l(MyCollectFrsActivity myCollectFrsActivity) {
        this.bjg = myCollectFrsActivity;
        initUI();
    }

    public void n(View.OnClickListener onClickListener) {
        this.SY = onClickListener;
    }

    private void initUI() {
        this.bke = this.bjg.findViewById(n.g.collect_frs);
        this.mNavigationBar = (NavigationBar) this.bjg.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(n.j.store_card_of_the_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bkf = this.bjg.findViewById(n.g.collect_frs_list_content);
        this.bkg = (BdTypeListView) this.bjg.findViewById(n.g.collect_frs_list_view);
        this.mPullView = new t(this.bjg.getPageContext());
        this.bkg.setDivider(null);
        this.bkg.setPullRefresh(this.mPullView);
        this.bkg.setDividerHeight(0);
        this.bkg.setRecyclerListener(new m(this));
        this.aVj = new PbListView(this.bjg.getPageContext().getPageActivity());
        this.aVj.mT();
        this.aVj.cO(n.d.cp_bg_line_c);
        this.bkg.setOnSrollToBottomListener(this.bjg);
        this.mNavigationBar.setOnTouchListener(new ab(new n(this)));
        this.bkh = new ew(this.bjg, this.bkg, ay.va().vc());
        this.aRD = (NoNetworkView) this.bjg.findViewById(n.g.view_no_network);
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void a(v vVar) {
        this.bkh.a(vVar);
    }

    public void a(w wVar) {
        this.bkh.a(wVar);
    }

    public void onDestroy() {
        this.bkh.onDestory();
        this.bkg.setOnSrollToBottomListener(null);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.bkh != null) {
            this.bkh.notifyDataSetChanged();
        }
        this.bjg.getLayoutMode().k(this.bke);
        this.mNavigationBar.onChangeSkinType(this.bjg.getPageContext(), i);
        this.aRD.onChangeSkinType(this.bjg.getPageContext(), i);
    }

    public void nb() {
        this.bkg.nb();
    }

    public ew OL() {
        return this.bkh;
    }

    public View getRootView() {
        return this.bke;
    }

    public void Ok() {
        this.mHasMore = true;
        this.bkg.setNextPage(this.aVj);
        this.aVj.startLoadData();
    }

    public void Ol() {
        this.mHasMore = false;
        if (this.bgZ > 0) {
            this.aVj.cQ(this.bgZ);
        }
        this.bkg.setNextPage(this.aVj);
        this.aVj.vP();
        this.aVj.setText(this.bjg.getResources().getString(n.j.list_no_more));
    }

    public void Om() {
        this.mHasMore = false;
        this.bkg.setNextPage(null);
        this.aVj.vQ();
    }

    public void gb(int i) {
        this.bgZ = i;
    }

    public void NW() {
        if (this.bkh != null) {
            this.bkh.notifyDataSetChanged();
        }
    }

    public void c(c.b bVar) {
        this.bgU = bVar;
    }

    public void a(z zVar, boolean z) {
        String string = this.bjg.getPageContext().getPageActivity().getString(n.j.view);
        String string2 = this.bjg.getPageContext().getPageActivity().getString(n.j.view_host);
        String string3 = this.bjg.getPageContext().getPageActivity().getString(n.j.view_reverse);
        if (this.bgR == null) {
            this.bgR = new com.baidu.tbadk.core.dialog.c(this.bjg.getPageContext().getPageActivity());
        }
        this.bgR.bJ(n.j.operation);
        if (z) {
            this.bgR.a(new String[]{string, string3}, this.bgU);
        } else {
            this.bgR.a(new String[]{string, string2, string3}, this.bgU);
        }
        this.bgR.d(this.bjg.getPageContext());
    }

    public void NT() {
        if (this.bgR != null) {
            this.bgR.tj();
        }
    }

    public void f(NoNetworkView.a aVar) {
        this.bbw = aVar;
        if (this.aRD != null) {
            this.aRD.a(this.bbw);
        }
    }

    public void release() {
        if (this.aRD != null && this.bbw != null) {
            this.aRD.b(this.bbw);
        }
    }

    public BdListView getListView() {
        return this.bkg;
    }

    public int Oc() {
        return 0;
    }

    public void completePullRefresh() {
        this.bkg.completePullRefresh();
    }

    public void a(ArrayList<u> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            cw cwVar = new cw();
            arrayList = new ArrayList<>();
            arrayList.add(cwVar);
        }
        this.bkh.a(arrayList, pVar);
    }

    public void hv(String str) {
        a(NoDataViewFactory.d.ac(str, this.bjg.getPageContext().getString(n.j.refresh_view_title_text)));
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bjg.getPageContext().getString(n.j.refresh_view_button_text), this.SY));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.bjg.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.bkf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(pageActivity, n.e.ds140)), dVar, a, false);
        }
        this.bkg.setVisibility(8);
        as.j(this.mNoDataView, n.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.bjg.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bkg.setVisibility(0);
    }
}
