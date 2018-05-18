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
    private NoNetworkView blp;
    private PbListView blq;
    private ChannelHomeActivity cxo;
    private g cxp;
    private f cxq;
    private com.baidu.tieba.channel.a.c cxr = null;
    private FrameLayout cxs = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cxo = channelHomeActivity;
        this.cxo.setIsAddSwipeBackLayout(true);
        this.cxo.setSwipeBackEnabled(true);
        this.cxo.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cxo.setContentView(d.i.channel_home_layout);
        this.mRootView = this.cxo.findViewById(d.g.channel_home_rootview);
        this.cxs = (FrameLayout) this.cxo.findViewById(d.g.channel_home_loading_view);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.cxp = new g(this.cxo.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.cxo);
        PJ();
    }

    private void PJ() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.cxq = new f(this.cxo.getPageContext().getPageActivity(), this.cxo);
        this.mListView.addHeaderView(this.cxq.acD());
        this.cxr = new com.baidu.tieba.channel.a.c(this.cxo.getPageContext().getPageActivity(), this.mListView);
        this.cxr.a(this.cxo);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cxo);
        this.blq = new PbListView(this.cxo.getPageContext().getPageActivity());
        this.blq.kz();
        this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.mListView.setNextPage(this.blq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cxq != null) {
            int dimension = (int) this.cxo.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cxo.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int agy = this.cxq.agy() - (i4 + (-this.cxq.acD().getTop()));
            if (this.cxp != null) {
                this.cxp.x(agy, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (agG() != null && agG().acD() != null) {
            this.cxo.getLayoutMode().setNightMode(i == 1);
            this.cxo.getLayoutMode().u(agG().acD());
        }
        agD();
        this.cxq.onChangeSkinType(i);
        this.cxp.onChangeSkinType(i);
        this.blq.dw(i);
        this.blp.onChangeSkinType(this.cxo.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.agj() != null) {
            this.cxq.eC(dVar.isHost());
            this.cxq.d(dVar);
            this.cxr.setIsHost(dVar.isHost());
            h(dVar);
            this.cxp.a(dVar.isHost(), this.cxo);
            this.cxp.O(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.agk() == null || dVar.agk().size() == 0) {
                Qn();
                this.mNoDataView = LayoutInflater.from(this.cxo.getPageContext().getPageActivity()).inflate(d.i.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eD(true);
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
                eD(true);
            }
        }
    }

    public void agD() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cxp.O(dVar);
        this.cxq.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cxq.f(dVar);
    }

    public void eD(boolean z) {
        this.blq.wR();
        if (z) {
            this.blq.setText(this.cxo.getPageContext().getPageActivity().getResources().getString(d.k.list_no_more));
        } else {
            this.blq.setText("");
        }
    }

    public void Qn() {
        this.blq.dy(0);
    }

    public void agE() {
        this.blq.wQ();
    }

    public void showLoadingView() {
        this.cxo.showLoadingView(this.cxs);
        this.cxs.setVisibility(0);
    }

    public void Os() {
        this.cxs.setVisibility(8);
        this.cxo.hideLoadingView(this.cxs);
    }

    public void showErrorView() {
        this.cxs.setVisibility(0);
        this.cxo.showNetRefreshView(this.cxs, this.cxo.getResources().getString(d.k.neterror));
    }

    public void agF() {
        this.cxs.setVisibility(8);
        this.cxo.hideNetRefreshView(this.cxs);
    }

    public f agG() {
        return this.cxq;
    }

    public void f(ChannelInfo channelInfo) {
        this.cxq.e(channelInfo);
    }
}
