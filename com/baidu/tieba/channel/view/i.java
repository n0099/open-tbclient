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
    private ChannelHomeActivity cwi;
    private g cwj;
    private f cwk;
    private com.baidu.tieba.channel.a.c cwl = null;
    private FrameLayout cwm = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cwi = channelHomeActivity;
        this.cwi.setIsAddSwipeBackLayout(true);
        this.cwi.setSwipeBackEnabled(true);
        this.cwi.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cwi.setContentView(d.i.channel_home_layout);
        this.mRootView = this.cwi.findViewById(d.g.channel_home_rootview);
        this.cwm = (FrameLayout) this.cwi.findViewById(d.g.channel_home_loading_view);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.cwj = new g(this.cwi.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.cwi);
        PM();
    }

    private void PM() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.cwk = new f(this.cwi.getPageContext().getPageActivity(), this.cwi);
        this.mListView.addHeaderView(this.cwk.acD());
        this.cwl = new com.baidu.tieba.channel.a.c(this.cwi.getPageContext().getPageActivity(), this.mListView);
        this.cwl.a(this.cwi);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cwi);
        this.blb = new PbListView(this.cwi.getPageContext().getPageActivity());
        this.blb.kA();
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.mListView.setNextPage(this.blb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cwk != null) {
            int dimension = (int) this.cwi.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cwi.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int agy = this.cwk.agy() - (i4 + (-this.cwk.acD().getTop()));
            if (this.cwj != null) {
                this.cwj.x(agy, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (agG() != null && agG().acD() != null) {
            this.cwi.getLayoutMode().setNightMode(i == 1);
            this.cwi.getLayoutMode().u(agG().acD());
        }
        agD();
        this.cwk.onChangeSkinType(i);
        this.cwj.onChangeSkinType(i);
        this.blb.dv(i);
        this.bla.onChangeSkinType(this.cwi.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.agj() != null) {
            this.cwk.eB(dVar.isHost());
            this.cwk.d(dVar);
            this.cwl.setIsHost(dVar.isHost());
            h(dVar);
            this.cwj.a(dVar.isHost(), this.cwi);
            this.cwj.O(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.agk() == null || dVar.agk().size() == 0) {
                Qq();
                this.mNoDataView = LayoutInflater.from(this.cwi.getPageContext().getPageActivity()).inflate(d.i.channel_home_no_data, (ViewGroup) null);
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
        this.cwj.O(dVar);
        this.cwk.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cwk.f(dVar);
    }

    public void eC(boolean z) {
        this.blb.wS();
        if (z) {
            this.blb.setText(this.cwi.getPageContext().getPageActivity().getResources().getString(d.k.list_no_more));
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
        this.cwi.showLoadingView(this.cwm);
        this.cwm.setVisibility(0);
    }

    public void Ou() {
        this.cwm.setVisibility(8);
        this.cwi.hideLoadingView(this.cwm);
    }

    public void showErrorView() {
        this.cwm.setVisibility(0);
        this.cwi.showNetRefreshView(this.cwm, this.cwi.getResources().getString(d.k.neterror));
    }

    public void agF() {
        this.cwm.setVisibility(8);
        this.cwi.hideNetRefreshView(this.cwm);
    }

    public f agG() {
        return this.cwk;
    }

    public void f(ChannelInfo channelInfo) {
        this.cwk.e(channelInfo);
    }
}
