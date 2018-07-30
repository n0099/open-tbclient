package com.baidu.tieba.channel.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
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
    private PbListView bvA;
    private NoNetworkView bvz;
    private ChannelHomeActivity cGq;
    private g cGr;
    private f cGs;
    private com.baidu.tieba.channel.a.c cGt = null;
    private FrameLayout cGu = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cGq = channelHomeActivity;
        this.cGq.setIsAddSwipeBackLayout(true);
        this.cGq.setSwipeBackEnabled(true);
        this.cGq.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cGq.setContentView(d.h.channel_home_layout);
        this.mRootView = this.cGq.findViewById(d.g.channel_home_rootview);
        this.cGu = (FrameLayout) this.cGq.findViewById(d.g.channel_home_loading_view);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.cGr = new g(this.cGq.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.cGq);
        TJ();
    }

    private void TJ() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.cGs = new f(this.cGq.getPageContext().getPageActivity(), this.cGq);
        this.mListView.addHeaderView(this.cGs.ahb());
        this.cGt = new com.baidu.tieba.channel.a.c(this.cGq.getPageContext().getPageActivity(), this.mListView);
        this.cGt.a(this.cGq);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cGq);
        this.bvA = new PbListView(this.cGq.getPageContext().getPageActivity());
        this.bvA.np();
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
        this.mListView.setNextPage(this.bvA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cGs != null) {
            int dimension = (int) this.cGq.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cGq.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int ajY = this.cGs.ajY() - (i4 + (-this.cGs.ahb().getTop()));
            if (this.cGr != null) {
                this.cGr.x(ajY, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (akh() != null && akh().ahb() != null) {
            this.cGq.getLayoutMode().setNightMode(i == 1);
            this.cGq.getLayoutMode().onModeChanged(akh().ahb());
        }
        akd();
        this.cGs.onChangeSkinType(i);
        this.cGr.onChangeSkinType(i);
        this.bvA.dC(i);
        this.bvz.onChangeSkinType(this.cGq.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajJ() != null) {
            this.cGs.eH(dVar.isHost());
            this.cGs.d(dVar);
            this.cGt.setIsHost(dVar.isHost());
            h(dVar);
            this.cGr.a(dVar.isHost(), this.cGq);
            this.cGr.T(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.ajK() == null || dVar.ajK().size() == 0) {
                Un();
                this.mNoDataView = LayoutInflater.from(this.cGq.getPageContext().getPageActivity()).inflate(d.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eI(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.ajK() != null) {
                Iterator<E> it = dVar.ajK().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.ajL()) {
                eI(true);
            }
        }
    }

    public void akd() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cGr.T(dVar);
        this.cGs.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cGs.f(dVar);
    }

    public void eI(boolean z) {
        this.bvA.Ay();
        if (z) {
            this.bvA.setText(this.cGq.getPageContext().getPageActivity().getResources().getString(d.j.list_no_more));
        } else {
            this.bvA.setText("");
        }
    }

    public void Un() {
        this.bvA.dE(0);
    }

    public void ake() {
        this.bvA.Ax();
    }

    public void showLoadingView() {
        this.cGq.showLoadingView(this.cGu);
        this.cGu.setVisibility(0);
    }

    public void hideLoadingView() {
        this.cGu.setVisibility(8);
        this.cGq.hideLoadingView(this.cGu);
    }

    public void akf() {
        this.cGu.setVisibility(0);
        this.cGq.showNetRefreshView(this.cGu, this.cGq.getResources().getString(d.j.neterror));
    }

    public void akg() {
        this.cGu.setVisibility(8);
        this.cGq.hideNetRefreshView(this.cGu);
    }

    public f akh() {
        return this.cGs;
    }

    public void f(ChannelInfo channelInfo) {
        this.cGs.e(channelInfo);
    }
}
