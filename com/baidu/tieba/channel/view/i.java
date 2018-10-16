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
    private NoNetworkView bJX;
    private PbListView bJY;
    private com.baidu.tieba.channel.a.c cUA = null;
    private FrameLayout cUB = null;
    private ChannelHomeActivity cUx;
    private g cUy;
    private f cUz;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cUx = channelHomeActivity;
        this.cUx.setIsAddSwipeBackLayout(true);
        this.cUx.setSwipeBackEnabled(true);
        this.cUx.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cUx.setContentView(e.h.channel_home_layout);
        this.mRootView = this.cUx.findViewById(e.g.channel_home_rootview);
        this.cUB = (FrameLayout) this.cUx.findViewById(e.g.channel_home_loading_view);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.channel_home_no_network_view);
        this.cUy = new g(this.cUx.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(e.g.channel_home_navigation_bar), this.cUx);
        Zg();
    }

    private void Zg() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.channel_home_listview);
        this.cUz = new f(this.cUx.getPageContext().getPageActivity(), this.cUx);
        this.mListView.addHeaderView(this.cUz.amt());
        this.cUA = new com.baidu.tieba.channel.a.c(this.cUx.getPageContext().getPageActivity(), this.mListView);
        this.cUA.a(this.cUx);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cUx);
        this.bJY = new PbListView(this.cUx.getPageContext().getPageActivity());
        this.bJY.oG();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
        this.mListView.setNextPage(this.bJY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cUz != null) {
            int dimension = (int) this.cUx.getResources().getDimension(e.C0175e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cUx.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int apo = this.cUz.apo() - (i4 + (-this.cUz.amt().getTop()));
            if (this.cUy != null) {
                this.cUy.C(apo, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (apu() != null && apu().amt() != null) {
            this.cUx.getLayoutMode().setNightMode(i == 1);
            this.cUx.getLayoutMode().onModeChanged(apu().amt());
        }
        notifyDataChanged();
        this.cUz.onChangeSkinType(i);
        this.cUy.onChangeSkinType(i);
        this.bJY.dW(i);
        this.bJX.onChangeSkinType(this.cUx.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aoZ() != null) {
            this.cUz.fq(dVar.isHost());
            this.cUz.d(dVar);
            this.cUA.setIsHost(dVar.isHost());
            h(dVar);
            this.cUy.a(dVar.isHost(), this.cUx);
            this.cUy.aa(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.apa() == null || dVar.apa().size() == 0) {
                ZK();
                this.mNoDataView = LayoutInflater.from(this.cUx.getPageContext().getPageActivity()).inflate(e.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                fr(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.apa() != null) {
                Iterator<E> it = dVar.apa().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.apb()) {
                fr(true);
            }
        }
    }

    public void notifyDataChanged() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cUy.aa(dVar);
        this.cUz.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cUz.f(dVar);
    }

    public void fr(boolean z) {
        this.bJY.DP();
        if (z) {
            this.bJY.setText(this.cUx.getPageContext().getPageActivity().getResources().getString(e.j.list_no_more));
        } else {
            this.bJY.setText("");
        }
    }

    public void ZK() {
        this.bJY.dY(0);
    }

    public void apt() {
        this.bJY.DO();
    }

    public void showLoadingView() {
        this.cUx.showLoadingView(this.cUB);
        this.cUB.setVisibility(0);
    }

    public void hideLoadingView() {
        this.cUB.setVisibility(8);
        this.cUx.hideLoadingView(this.cUB);
    }

    public void showErrorView() {
        this.cUB.setVisibility(0);
        this.cUx.showNetRefreshView(this.cUB, this.cUx.getResources().getString(e.j.neterror));
    }

    public void hideErrorView() {
        this.cUB.setVisibility(8);
        this.cUx.hideNetRefreshView(this.cUB);
    }

    public f apu() {
        return this.cUz;
    }

    public void f(ChannelInfo channelInfo) {
        this.cUz.e(channelInfo);
    }
}
