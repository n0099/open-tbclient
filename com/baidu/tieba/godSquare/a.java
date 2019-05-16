package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity cVo;
    private PbListView dlX;
    private NoNetworkView eRU;
    private com.baidu.tieba.godSquare.a.a fVe;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cVo = baseActivity;
        this.cVo.setContentView(R.layout.god_square_activity);
        this.mRootView = this.cVo.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cVo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eRU = (NoNetworkView) this.cVo.findViewById(R.id.view_no_network);
        this.dlX = new PbListView(this.cVo.getPageContext().getPageActivity());
        this.dlX.nG();
        this.dlX.ajy();
        this.mListView = (BdTypeListView) this.cVo.findViewById(R.id.god_square_list_view);
        this.mPullView = new i(this.cVo.getPageContext());
        if (this.cVo instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cVo);
        }
        if (this.cVo instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cVo);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.fVe = new com.baidu.tieba.godSquare.a.a(this.cVo.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.fVe.aHM());
        this.mListView.setNextPage(this.dlX);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cVo.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cVo.hideLoadingView(this.mRootView);
    }

    public void wk(String str) {
        this.mListView.setVisibility(8);
        this.cVo.showNetRefreshView(this.mRootView, str, true);
    }

    public void aHH() {
        this.mListView.setVisibility(0);
        this.cVo.hideNetRefreshView(this.mRootView);
    }

    public void cx(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.fVe.notifyDataSetChanged();
    }

    public void bsm() {
        this.dlX.ajy();
    }

    public void bsn() {
        this.dlX.setText(this.cVo.getResources().getString(R.string.network_ungeilivable));
        this.dlX.ajz();
    }

    public void bso() {
        this.dlX.setText(this.cVo.getResources().getString(R.string.list_no_more));
        this.dlX.ajz();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVo.getPageContext(), i);
        this.dlX.iO(R.color.cp_bg_line_c);
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
        this.dlX.iP(i);
        this.eRU.onChangeSkinType(this.cVo.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eRU.a(aVar);
        }
    }
}
