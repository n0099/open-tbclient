package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private NoNetworkView aWZ;
    private com.baidu.tieba.godSquare.a.a bKf;
    private BdTypeListView bej;
    private BaseActivity bek;
    private PbListView bkd;
    private NavigationBar mNavigationBar;
    private w mPullView;
    private View mRootView;

    public d(BaseActivity baseActivity) {
        this.bek = baseActivity;
        this.bek.setContentView(t.h.god_square_activity);
        this.mRootView = this.bek.findViewById(t.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bek.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(t.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWZ = (NoNetworkView) this.bek.findViewById(t.g.view_no_network);
        this.bkd = new PbListView(this.bek.getPageContext().getPageActivity());
        this.bkd.jn();
        this.bkd.vh();
        this.bej = (BdTypeListView) this.bek.findViewById(t.g.god_square_list_view);
        this.mPullView = new w(this.bek.getPageContext());
        if (this.bek instanceof t.b) {
            this.mPullView.a((t.b) this.bek);
        }
        if (this.bek instanceof BdListView.e) {
            this.bej.setOnSrollToBottomListener((BdListView.e) this.bek);
        }
        this.bej.setPullRefresh(this.mPullView);
        this.bKf = new com.baidu.tieba.godSquare.a.a(this.bek.getPageContext(), this.bej);
        this.bej.g(this.bKf.Pd());
        this.bej.setNextPage(this.bkd);
    }

    public void Pe() {
        this.bej.setVisibility(8);
        this.bek.showLoadingView(this.mRootView, true);
    }

    public void Pf() {
        this.bej.setVisibility(0);
        this.bek.hideLoadingView(this.mRootView);
    }

    public void hF(String str) {
        this.bej.setVisibility(8);
        this.bek.showNetRefreshView(this.mRootView, str, true);
    }

    public void Pg() {
        this.bej.setVisibility(0);
        this.bek.hideNetRefreshView(this.mRootView);
    }

    public void aO(List<v> list) {
        if (list != null) {
            this.bej.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.bej;
    }

    public void notifyDataSetChanged() {
        this.bKf.notifyDataSetChanged();
    }

    public void XX() {
        this.bkd.vh();
    }

    public void XY() {
        this.bkd.setText(this.bek.getResources().getString(t.j.network_ungeilivable));
        this.bkd.vi();
    }

    public void XZ() {
        this.bkd.setText(this.bek.getResources().getString(t.j.list_no_more));
        this.bkd.vi();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bek.getPageContext(), i);
        this.bkd.cQ(t.d.cp_bg_line_c);
        this.bkd.setTextColor(at.getColor(t.d.cp_cont_d));
        this.bkd.cR(i);
        this.aWZ.onChangeSkinType(this.bek.getPageContext(), i);
    }

    public void jy() {
        this.bej.jy();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aWZ.a(aVar);
        }
    }
}
