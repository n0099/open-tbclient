package com.baidu.tieba.channel.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class i {
    private NoNetworkView dbq;
    private PbListView dbr;
    private g epA;
    private f epB;
    private com.baidu.tieba.channel.a.c epC = null;
    private FrameLayout epD = null;
    private ChannelHomeActivity epz;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.epz = channelHomeActivity;
        this.epz.setIsAddSwipeBackLayout(true);
        this.epz.setSwipeBackEnabled(true);
        this.epz.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.epz.setContentView(d.h.channel_home_layout);
        this.mRootView = this.epz.findViewById(d.g.channel_home_rootview);
        this.epD = (FrameLayout) this.epz.findViewById(d.g.channel_home_loading_view);
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.epA = new g(this.epz.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.epz);
        aBW();
    }

    private void aBW() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.epB = new f(this.epz.getPageContext().getPageActivity(), this.epz);
        this.mListView.addHeaderView(this.epB.aOH());
        this.epC = new com.baidu.tieba.channel.a.c(this.epz.getPageContext().getPageActivity(), this.mListView);
        this.epC.a(this.epz);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.epz);
        this.dbr = new PbListView(this.epz.getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.mListView.setNextPage(this.dbr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.epB != null) {
            int dimension = (int) this.epz.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.epz.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aRE = this.epB.aRE() - (i4 + (-this.epB.aOH().getTop()));
            if (this.epA != null) {
                this.epA.F(aRE, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (aRK() != null && aRK().aOH() != null) {
            this.epz.getLayoutMode().setNightMode(i == 1);
            this.epz.getLayoutMode().onModeChanged(aRK().aOH());
        }
        Rs();
        this.epB.onChangeSkinType(i);
        this.epA.onChangeSkinType(i);
        this.dbr.ib(i);
        this.dbq.onChangeSkinType(this.epz.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aRq() != null) {
            this.epB.hZ(dVar.isHost());
            this.epB.d(dVar);
            this.epC.setIsHost(dVar.isHost());
            h(dVar);
            this.epA.a(dVar.isHost(), this.epz);
            this.epA.am(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aRr() == null || dVar.aRr().size() == 0) {
                aCt();
                this.mNoDataView = LayoutInflater.from(this.epz.getPageContext().getPageActivity()).inflate(d.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                ia(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aRr() != null) {
                Iterator<E> it = dVar.aRr().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aRs()) {
                ia(true);
            }
        }
    }

    public void Rs() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.epA.am(dVar);
        this.epB.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.epB.f(dVar);
    }

    public void ia(boolean z) {
        this.dbr.aeA();
        if (z) {
            this.dbr.setText(this.epz.getPageContext().getPageActivity().getResources().getString(d.j.list_no_more));
        } else {
            this.dbr.setText("");
        }
    }

    public void aCt() {
        this.dbr.id(0);
    }

    public void aRJ() {
        this.dbr.aez();
    }

    public void showLoadingView() {
        this.epz.showLoadingView(this.epD);
        this.epD.setVisibility(0);
    }

    public void hideLoadingView() {
        this.epD.setVisibility(8);
        this.epz.hideLoadingView(this.epD);
    }

    public void zX() {
        this.epD.setVisibility(0);
        this.epz.showNetRefreshView(this.epD, this.epz.getResources().getString(d.j.neterror));
    }

    public void zY() {
        this.epD.setVisibility(8);
        this.epz.hideNetRefreshView(this.epD);
    }

    public f aRK() {
        return this.epB;
    }

    public void f(ChannelInfo channelInfo) {
        this.epB.e(channelInfo);
    }
}
