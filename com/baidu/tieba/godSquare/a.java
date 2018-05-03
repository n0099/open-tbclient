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
    private BaseActivity bcJ;
    private PbListView blb;
    private NoNetworkView cHy;
    private com.baidu.tieba.godSquare.a.a dyI;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private f mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bcJ = baseActivity;
        this.bcJ.setContentView(d.i.god_square_activity);
        this.mRootView = this.bcJ.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bcJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cHy = (NoNetworkView) this.bcJ.findViewById(d.g.view_no_network);
        this.blb = new PbListView(this.bcJ.getPageContext().getPageActivity());
        this.blb.kA();
        this.blb.wR();
        this.mListView = (BdTypeListView) this.bcJ.findViewById(d.g.god_square_list_view);
        this.mPullView = new f(this.bcJ.getPageContext());
        if (this.bcJ instanceof e.b) {
            this.mPullView.a((e.b) this.bcJ);
        }
        if (this.bcJ instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bcJ);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dyI = new com.baidu.tieba.godSquare.a.a(this.bcJ.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.dyI.aoq());
        this.mListView.setNextPage(this.blb);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bcJ.showLoadingView(this.mRootView, true);
    }

    public void Ou() {
        this.mListView.setVisibility(0);
        this.bcJ.hideLoadingView(this.mRootView);
    }

    public void lE(String str) {
        this.mListView.setVisibility(8);
        this.bcJ.showNetRefreshView(this.mRootView, str, true);
    }

    public void Qn() {
        this.mListView.setVisibility(0);
        this.bcJ.hideNetRefreshView(this.mRootView);
    }

    public void bC(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.dyI.notifyDataSetChanged();
    }

    public void awG() {
        this.blb.wR();
    }

    public void awH() {
        this.blb.setText(this.bcJ.getResources().getString(d.k.network_ungeilivable));
        this.blb.wS();
    }

    public void awI() {
        this.blb.setText(this.bcJ.getResources().getString(d.k.list_no_more));
        this.blb.wS();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bcJ.getPageContext(), i);
        this.blb.du(d.C0126d.cp_bg_line_c);
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.blb.dv(i);
        this.cHy.onChangeSkinType(this.bcJ.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cHy.a(aVar);
        }
    }
}
