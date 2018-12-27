package com.baidu.tieba.channel.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class i {
    private NoNetworkView bOA;
    private PbListView bOB;
    private ChannelHomeActivity dff;
    private g dfg;
    private f dfh;
    private com.baidu.tieba.channel.a.c dfi = null;
    private FrameLayout dfj = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.dff = channelHomeActivity;
        this.dff.setIsAddSwipeBackLayout(true);
        this.dff.setSwipeBackEnabled(true);
        this.dff.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.dff.setContentView(e.h.channel_home_layout);
        this.mRootView = this.dff.findViewById(e.g.channel_home_rootview);
        this.dfj = (FrameLayout) this.dff.findViewById(e.g.channel_home_loading_view);
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.channel_home_no_network_view);
        this.dfg = new g(this.dff.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(e.g.channel_home_navigation_bar), this.dff);
        aaz();
    }

    private void aaz() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.channel_home_listview);
        this.dfh = new f(this.dff.getPageContext().getPageActivity(), this.dff);
        this.mListView.addHeaderView(this.dfh.anC());
        this.dfi = new com.baidu.tieba.channel.a.c(this.dff.getPageContext().getPageActivity(), this.mListView);
        this.dfi.a(this.dff);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.dff);
        this.bOB = new PbListView(this.dff.getPageContext().getPageActivity());
        this.bOB.oD();
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
        this.mListView.setNextPage(this.bOB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.dfh != null) {
            int dimension = (int) this.dff.getResources().getDimension(e.C0210e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.dff.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int arr = this.dfh.arr() - (i4 + (-this.dfh.anC().getTop()));
            if (this.dfg != null) {
                this.dfg.C(arr, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (arx() != null && arx().anC() != null) {
            this.dff.getLayoutMode().setNightMode(i == 1);
            this.dff.getLayoutMode().onModeChanged(arx().anC());
        }
        notifyDataChanged();
        this.dfh.onChangeSkinType(i);
        this.dfg.onChangeSkinType(i);
        this.bOB.ey(i);
        this.bOA.onChangeSkinType(this.dff.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ard() != null) {
            this.dfh.fE(dVar.isHost());
            this.dfh.d(dVar);
            this.dfi.setIsHost(dVar.isHost());
            h(dVar);
            this.dfg.a(dVar.isHost(), this.dff);
            this.dfg.Z(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.are() == null || dVar.are().size() == 0) {
                abd();
                this.mNoDataView = LayoutInflater.from(this.dff.getPageContext().getPageActivity()).inflate(e.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                fF(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.are() != null) {
                Iterator<E> it = dVar.are().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.arf()) {
                fF(true);
            }
        }
    }

    public void notifyDataChanged() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dfg.Z(dVar);
        this.dfh.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.dfh.f(dVar);
    }

    public void fF(boolean z) {
        this.bOB.Fd();
        if (z) {
            this.bOB.setText(this.dff.getPageContext().getPageActivity().getResources().getString(e.j.list_no_more));
        } else {
            this.bOB.setText("");
        }
    }

    public void abd() {
        this.bOB.eA(0);
    }

    public void arw() {
        this.bOB.Fc();
    }

    public void showLoadingView() {
        this.dff.showLoadingView(this.dfj);
        this.dfj.setVisibility(0);
    }

    public void hideLoadingView() {
        this.dfj.setVisibility(8);
        this.dff.hideLoadingView(this.dfj);
    }

    public void showErrorView() {
        this.dfj.setVisibility(0);
        this.dff.showNetRefreshView(this.dfj, this.dff.getResources().getString(e.j.neterror));
    }

    public void hideErrorView() {
        this.dfj.setVisibility(8);
        this.dff.hideNetRefreshView(this.dfj);
    }

    public f arx() {
        return this.dfh;
    }

    public void f(ChannelInfo channelInfo) {
        this.dfh.e(channelInfo);
    }
}
