package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tieba.godSquare.a.a bJZ;
    private NoNetworkView baT;
    private BdTypeListView bcd;
    private PbListView bcf;
    private BaseActivity bix;
    private NavigationBar mNavigationBar;
    private u mPullView;
    private View mRootView;

    public d(BaseActivity baseActivity) {
        this.bix = baseActivity;
        this.bix.setContentView(t.h.god_square_activity);
        this.mRootView = this.bix.findViewById(t.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bix.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(t.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.baT = (NoNetworkView) this.bix.findViewById(t.g.view_no_network);
        this.bcf = new PbListView(this.bix.getPageContext().getPageActivity());
        this.bcf.mZ();
        this.bcf.xu();
        this.bcd = (BdTypeListView) this.bix.findViewById(t.g.god_square_list_view);
        this.mPullView = new u(this.bix.getPageContext());
        if (this.bix instanceof s.a) {
            this.mPullView.a((s.a) this.bix);
        }
        if (this.bix instanceof BdListView.e) {
            this.bcd.setOnSrollToBottomListener((BdListView.e) this.bix);
        }
        this.bcd.setPullRefresh(this.mPullView);
        this.bJZ = new com.baidu.tieba.godSquare.a.a(this.bix.getPageContext(), this.bcd);
        this.bcd.g(this.bJZ.Yd());
        this.bcd.setNextPage(this.bcf);
    }

    public void Ql() {
        this.bcd.setVisibility(8);
        this.bix.showLoadingView(this.mRootView, true);
    }

    public void XX() {
        this.bcd.setVisibility(0);
        this.bix.hideLoadingView(this.mRootView);
    }

    public void in(String str) {
        this.bcd.setVisibility(8);
        this.bix.showNetRefreshView(this.mRootView, str, true);
    }

    public void XY() {
        this.bcd.setVisibility(0);
        this.bix.hideNetRefreshView(this.mRootView);
    }

    public void aQ(List<com.baidu.adp.widget.ListView.u> list) {
        if (list != null) {
            this.bcd.setData(list);
        }
    }

    public BdTypeListView XZ() {
        return this.bcd;
    }

    public void notifyDataSetChanged() {
        this.bJZ.notifyDataSetChanged();
    }

    public void Ya() {
        this.bcf.xu();
    }

    public void Yb() {
        this.bcf.setText(this.bix.getResources().getString(t.j.network_ungeilivable));
        this.bcf.xv();
    }

    public void Yc() {
        this.bcf.setText(this.bix.getResources().getString(t.j.list_no_more));
        this.bcf.xv();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bix.getPageContext(), i);
        this.bcf.di(t.d.cp_bg_line_c);
        this.bcf.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bcf.dj(i);
        this.baT.onChangeSkinType(this.bix.getPageContext(), i);
    }

    public void nk() {
        this.bcd.nk();
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.baT.a(aVar);
        }
    }
}
