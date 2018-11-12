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
    private NoNetworkView bKI;
    private PbListView bKJ;
    private ChannelHomeActivity cVD;
    private g cVE;
    private f cVF;
    private com.baidu.tieba.channel.a.c cVG = null;
    private FrameLayout cVH = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cVD = channelHomeActivity;
        this.cVD.setIsAddSwipeBackLayout(true);
        this.cVD.setSwipeBackEnabled(true);
        this.cVD.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cVD.setContentView(e.h.channel_home_layout);
        this.mRootView = this.cVD.findViewById(e.g.channel_home_rootview);
        this.cVH = (FrameLayout) this.cVD.findViewById(e.g.channel_home_loading_view);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.channel_home_no_network_view);
        this.cVE = new g(this.cVD.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(e.g.channel_home_navigation_bar), this.cVD);
        Zr();
    }

    private void Zr() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.channel_home_listview);
        this.cVF = new f(this.cVD.getPageContext().getPageActivity(), this.cVD);
        this.mListView.addHeaderView(this.cVF.alT());
        this.cVG = new com.baidu.tieba.channel.a.c(this.cVD.getPageContext().getPageActivity(), this.mListView);
        this.cVG.a(this.cVD);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cVD);
        this.bKJ = new PbListView(this.cVD.getPageContext().getPageActivity());
        this.bKJ.oE();
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
        this.mListView.setNextPage(this.bKJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cVF != null) {
            int dimension = (int) this.cVD.getResources().getDimension(e.C0200e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cVD.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aoP = this.cVF.aoP() - (i4 + (-this.cVF.alT().getTop()));
            if (this.cVE != null) {
                this.cVE.C(aoP, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (aoV() != null && aoV().alT() != null) {
            this.cVD.getLayoutMode().setNightMode(i == 1);
            this.cVD.getLayoutMode().onModeChanged(aoV().alT());
        }
        notifyDataChanged();
        this.cVF.onChangeSkinType(i);
        this.cVE.onChangeSkinType(i);
        this.bKJ.ek(i);
        this.bKI.onChangeSkinType(this.cVD.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aoB() != null) {
            this.cVF.fB(dVar.isHost());
            this.cVF.d(dVar);
            this.cVG.setIsHost(dVar.isHost());
            h(dVar);
            this.cVE.a(dVar.isHost(), this.cVD);
            this.cVE.Z(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aoC() == null || dVar.aoC().size() == 0) {
                ZV();
                this.mNoDataView = LayoutInflater.from(this.cVD.getPageContext().getPageActivity()).inflate(e.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                fC(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aoC() != null) {
                Iterator<E> it = dVar.aoC().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aoD()) {
                fC(true);
            }
        }
    }

    public void notifyDataChanged() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cVE.Z(dVar);
        this.cVF.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cVF.f(dVar);
    }

    public void fC(boolean z) {
        this.bKJ.DZ();
        if (z) {
            this.bKJ.setText(this.cVD.getPageContext().getPageActivity().getResources().getString(e.j.list_no_more));
        } else {
            this.bKJ.setText("");
        }
    }

    public void ZV() {
        this.bKJ.em(0);
    }

    public void aoU() {
        this.bKJ.DY();
    }

    public void showLoadingView() {
        this.cVD.showLoadingView(this.cVH);
        this.cVH.setVisibility(0);
    }

    public void hideLoadingView() {
        this.cVH.setVisibility(8);
        this.cVD.hideLoadingView(this.cVH);
    }

    public void showErrorView() {
        this.cVH.setVisibility(0);
        this.cVD.showNetRefreshView(this.cVH, this.cVD.getResources().getString(e.j.neterror));
    }

    public void hideErrorView() {
        this.cVH.setVisibility(8);
        this.cVD.hideNetRefreshView(this.cVH);
    }

    public f aoV() {
        return this.cVF;
    }

    public void f(ChannelInfo channelInfo) {
        this.cVF.e(channelInfo);
    }
}
