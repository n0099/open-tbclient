package com.baidu.tieba.channel.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class i {
    private NoNetworkView bla;
    private PbListView blb;
    private ChannelHomeActivity cwf;
    private g cwg;
    private f cwh;
    private com.baidu.tieba.channel.a.c cwi = null;
    private FrameLayout cwj = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cwf = channelHomeActivity;
        this.cwf.setIsAddSwipeBackLayout(true);
        this.cwf.setSwipeBackEnabled(true);
        this.cwf.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cwf.setContentView(d.i.channel_home_layout);
        this.mRootView = this.cwf.findViewById(d.g.channel_home_rootview);
        this.cwj = (FrameLayout) this.cwf.findViewById(d.g.channel_home_loading_view);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.cwg = new g(this.cwf.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.cwf);
        PM();
    }

    private void PM() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.cwh = new f(this.cwf.getPageContext().getPageActivity(), this.cwf);
        this.mListView.addHeaderView(this.cwh.acD());
        this.cwi = new com.baidu.tieba.channel.a.c(this.cwf.getPageContext().getPageActivity(), this.mListView);
        this.cwi.a(this.cwf);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cwf);
        this.blb = new PbListView(this.cwf.getPageContext().getPageActivity());
        this.blb.kA();
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.mListView.setNextPage(this.blb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cwh != null) {
            int dimension = (int) this.cwf.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cwf.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int agy = this.cwh.agy() - (i4 + (-this.cwh.acD().getTop()));
            if (this.cwg != null) {
                this.cwg.x(agy, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (agG() != null && agG().acD() != null) {
            this.cwf.getLayoutMode().setNightMode(i == 1);
            this.cwf.getLayoutMode().u(agG().acD());
        }
        agD();
        this.cwh.onChangeSkinType(i);
        this.cwg.onChangeSkinType(i);
        this.blb.dv(i);
        this.bla.onChangeSkinType(this.cwf.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.agj() != null) {
            this.cwh.eB(dVar.isHost());
            this.cwh.d(dVar);
            this.cwi.setIsHost(dVar.isHost());
            h(dVar);
            this.cwg.a(dVar.isHost(), this.cwf);
            this.cwg.O(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.agk() == null || dVar.agk().size() == 0) {
                Qq();
                this.mNoDataView = LayoutInflater.from(this.cwf.getPageContext().getPageActivity()).inflate(d.i.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eC(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.agk() != null) {
                Iterator<E> it = dVar.agk().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.agl()) {
                eC(true);
            }
        }
    }

    public void agD() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cwg.O(dVar);
        this.cwh.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cwh.f(dVar);
    }

    public void eC(boolean z) {
        this.blb.wS();
        if (z) {
            this.blb.setText(this.cwf.getPageContext().getPageActivity().getResources().getString(d.k.list_no_more));
        } else {
            this.blb.setText("");
        }
    }

    public void Qq() {
        this.blb.dx(0);
    }

    public void agE() {
        this.blb.wR();
    }

    public void showLoadingView() {
        this.cwf.showLoadingView(this.cwj);
        this.cwj.setVisibility(0);
    }

    public void Ou() {
        this.cwj.setVisibility(8);
        this.cwf.hideLoadingView(this.cwj);
    }

    public void showErrorView() {
        this.cwj.setVisibility(0);
        this.cwf.showNetRefreshView(this.cwj, this.cwf.getResources().getString(d.k.neterror));
    }

    public void agF() {
        this.cwj.setVisibility(8);
        this.cwf.hideNetRefreshView(this.cwj);
    }

    public f agG() {
        return this.cwh;
    }

    public void f(ChannelInfo channelInfo) {
        this.cwh.e(channelInfo);
    }
}
