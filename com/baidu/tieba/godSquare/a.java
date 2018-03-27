package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BaseActivity bSF;
    private PbListView cbb;
    private NoNetworkView dpl;
    private com.baidu.tieba.godSquare.a.a eef;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bSF = baseActivity;
        this.bSF.setContentView(d.h.god_square_activity);
        this.mRootView = this.bSF.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bSF.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dpl = (NoNetworkView) this.bSF.findViewById(d.g.view_no_network);
        this.cbb = new PbListView(this.bSF.getPageContext().getPageActivity());
        this.cbb.st();
        this.cbb.Eg();
        this.mListView = (BdTypeListView) this.bSF.findViewById(d.g.god_square_list_view);
        this.mPullView = new k(this.bSF.getPageContext());
        if (this.bSF instanceof j.b) {
            this.mPullView.a((j.b) this.bSF);
        }
        if (this.bSF instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bSF);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.eef = new com.baidu.tieba.godSquare.a.a(this.bSF.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.eef.aub());
        this.mListView.setNextPage(this.cbb);
    }

    public void VU() {
        this.mListView.setVisibility(8);
        this.bSF.showLoadingView(this.mRootView, true);
    }

    public void VV() {
        this.mListView.setVisibility(0);
        this.bSF.hideLoadingView(this.mRootView);
    }

    public void lB(String str) {
        this.mListView.setVisibility(8);
        this.bSF.showNetRefreshView(this.mRootView, str, true);
    }

    public void XN() {
        this.mListView.setVisibility(0);
        this.bSF.hideNetRefreshView(this.mRootView);
    }

    public void bI(List<i> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.eef.notifyDataSetChanged();
    }

    public void aBK() {
        this.cbb.Eg();
    }

    public void aBL() {
        this.cbb.setText(this.bSF.getResources().getString(d.j.network_ungeilivable));
        this.cbb.Eh();
    }

    public void aBM() {
        this.cbb.setText(this.bSF.getResources().getString(d.j.list_no_more));
        this.cbb.Eh();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSF.getPageContext(), i);
        this.cbb.gw(d.C0141d.cp_bg_line_c);
        this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
        this.cbb.gx(i);
        this.dpl.onChangeSkinType(this.bSF.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dpl.a(aVar);
        }
    }
}
