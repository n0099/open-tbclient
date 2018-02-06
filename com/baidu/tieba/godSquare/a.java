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
    private BaseActivity bSO;
    private PbListView cbk;
    private NoNetworkView dpu;
    private com.baidu.tieba.godSquare.a.a eeb;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bSO = baseActivity;
        this.bSO.setContentView(d.h.god_square_activity);
        this.mRootView = this.bSO.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bSO.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dpu = (NoNetworkView) this.bSO.findViewById(d.g.view_no_network);
        this.cbk = new PbListView(this.bSO.getPageContext().getPageActivity());
        this.cbk.st();
        this.cbk.Eg();
        this.mListView = (BdTypeListView) this.bSO.findViewById(d.g.god_square_list_view);
        this.mPullView = new k(this.bSO.getPageContext());
        if (this.bSO instanceof j.b) {
            this.mPullView.a((j.b) this.bSO);
        }
        if (this.bSO instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bSO);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.eeb = new com.baidu.tieba.godSquare.a.a(this.bSO.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.eeb.aub());
        this.mListView.setNextPage(this.cbk);
    }

    public void VU() {
        this.mListView.setVisibility(8);
        this.bSO.showLoadingView(this.mRootView, true);
    }

    public void VV() {
        this.mListView.setVisibility(0);
        this.bSO.hideLoadingView(this.mRootView);
    }

    public void lB(String str) {
        this.mListView.setVisibility(8);
        this.bSO.showNetRefreshView(this.mRootView, str, true);
    }

    public void XN() {
        this.mListView.setVisibility(0);
        this.bSO.hideNetRefreshView(this.mRootView);
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
        this.eeb.notifyDataSetChanged();
    }

    public void aBK() {
        this.cbk.Eg();
    }

    public void aBL() {
        this.cbk.setText(this.bSO.getResources().getString(d.j.network_ungeilivable));
        this.cbk.Eh();
    }

    public void aBM() {
        this.cbk.setText(this.bSO.getResources().getString(d.j.list_no_more));
        this.cbk.Eh();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSO.getPageContext(), i);
        this.cbk.gw(d.C0140d.cp_bg_line_c);
        this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
        this.cbk.gx(i);
        this.dpu.onChangeSkinType(this.bSO.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dpu.a(aVar);
        }
    }
}
