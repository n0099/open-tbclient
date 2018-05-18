package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BaseActivity bcK;
    private PbListView blq;
    private NoNetworkView cIH;
    private com.baidu.tieba.godSquare.a.a dzP;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private f mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bcK = baseActivity;
        this.bcK.setContentView(d.i.god_square_activity);
        this.mRootView = this.bcK.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bcK.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cIH = (NoNetworkView) this.bcK.findViewById(d.g.view_no_network);
        this.blq = new PbListView(this.bcK.getPageContext().getPageActivity());
        this.blq.kz();
        this.blq.wQ();
        this.mListView = (BdTypeListView) this.bcK.findViewById(d.g.god_square_list_view);
        this.mPullView = new f(this.bcK.getPageContext());
        if (this.bcK instanceof e.b) {
            this.mPullView.a((e.b) this.bcK);
        }
        if (this.bcK instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bcK);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dzP = new com.baidu.tieba.godSquare.a.a(this.bcK.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.dzP.aop());
        this.mListView.setNextPage(this.blq);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bcK.showLoadingView(this.mRootView, true);
    }

    public void Os() {
        this.mListView.setVisibility(0);
        this.bcK.hideLoadingView(this.mRootView);
    }

    public void lH(String str) {
        this.mListView.setVisibility(8);
        this.bcK.showNetRefreshView(this.mRootView, str, true);
    }

    public void Qk() {
        this.mListView.setVisibility(0);
        this.bcK.hideNetRefreshView(this.mRootView);
    }

    public void bF(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.dzP.notifyDataSetChanged();
    }

    public void awF() {
        this.blq.wQ();
    }

    public void awG() {
        this.blq.setText(this.bcK.getResources().getString(d.k.network_ungeilivable));
        this.blq.wR();
    }

    public void awH() {
        this.blq.setText(this.bcK.getResources().getString(d.k.list_no_more));
        this.blq.wR();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bcK.getPageContext(), i);
        this.blq.dv(d.C0126d.cp_bg_line_c);
        this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.blq.dw(i);
        this.cIH.onChangeSkinType(this.bcK.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cIH.a(aVar);
        }
    }
}
