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
    private BaseActivity bSC;
    private PbListView caY;
    private NoNetworkView dpi;
    private com.baidu.tieba.godSquare.a.a edP;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bSC = baseActivity;
        this.bSC.setContentView(d.h.god_square_activity);
        this.mRootView = this.bSC.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bSC.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dpi = (NoNetworkView) this.bSC.findViewById(d.g.view_no_network);
        this.caY = new PbListView(this.bSC.getPageContext().getPageActivity());
        this.caY.st();
        this.caY.Ef();
        this.mListView = (BdTypeListView) this.bSC.findViewById(d.g.god_square_list_view);
        this.mPullView = new k(this.bSC.getPageContext());
        if (this.bSC instanceof j.b) {
            this.mPullView.a((j.b) this.bSC);
        }
        if (this.bSC instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bSC);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.edP = new com.baidu.tieba.godSquare.a.a(this.bSC.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.edP.aua());
        this.mListView.setNextPage(this.caY);
    }

    public void VT() {
        this.mListView.setVisibility(8);
        this.bSC.showLoadingView(this.mRootView, true);
    }

    public void VU() {
        this.mListView.setVisibility(0);
        this.bSC.hideLoadingView(this.mRootView);
    }

    public void lB(String str) {
        this.mListView.setVisibility(8);
        this.bSC.showNetRefreshView(this.mRootView, str, true);
    }

    public void XM() {
        this.mListView.setVisibility(0);
        this.bSC.hideNetRefreshView(this.mRootView);
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
        this.edP.notifyDataSetChanged();
    }

    public void aBJ() {
        this.caY.Ef();
    }

    public void aBK() {
        this.caY.setText(this.bSC.getResources().getString(d.j.network_ungeilivable));
        this.caY.Eg();
    }

    public void aBL() {
        this.caY.setText(this.bSC.getResources().getString(d.j.list_no_more));
        this.caY.Eg();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSC.getPageContext(), i);
        this.caY.gw(d.C0141d.cp_bg_line_c);
        this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
        this.caY.gx(i);
        this.dpi.onChangeSkinType(this.bSC.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dpi.a(aVar);
        }
    }
}
