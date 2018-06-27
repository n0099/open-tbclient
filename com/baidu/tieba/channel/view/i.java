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
    private NoNetworkView buT;
    private PbListView buU;
    private ChannelHomeActivity cDK;
    private g cDL;
    private f cDM;
    private com.baidu.tieba.channel.a.c cDN = null;
    private FrameLayout cDO = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cDK = channelHomeActivity;
        this.cDK.setIsAddSwipeBackLayout(true);
        this.cDK.setSwipeBackEnabled(true);
        this.cDK.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cDK.setContentView(d.i.channel_home_layout);
        this.mRootView = this.cDK.findViewById(d.g.channel_home_rootview);
        this.cDO = (FrameLayout) this.cDK.findViewById(d.g.channel_home_loading_view);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.cDL = new g(this.cDK.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.cDK);
        TB();
    }

    private void TB() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.cDM = new f(this.cDK.getPageContext().getPageActivity(), this.cDK);
        this.mListView.addHeaderView(this.cDM.agG());
        this.cDN = new com.baidu.tieba.channel.a.c(this.cDK.getPageContext().getPageActivity(), this.mListView);
        this.cDN.a(this.cDK);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cDK);
        this.buU = new PbListView(this.cDK.getPageContext().getPageActivity());
        this.buU.nn();
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
        this.mListView.setNextPage(this.buU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cDM != null) {
            int dimension = (int) this.cDK.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cDK.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int ajA = this.cDM.ajA() - (i4 + (-this.cDM.agG().getTop()));
            if (this.cDL != null) {
                this.cDL.x(ajA, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (ajI() != null && ajI().agG() != null) {
            this.cDK.getLayoutMode().setNightMode(i == 1);
            this.cDK.getLayoutMode().onModeChanged(ajI().agG());
        }
        ajF();
        this.cDM.onChangeSkinType(i);
        this.cDL.onChangeSkinType(i);
        this.buU.dz(i);
        this.buT.onChangeSkinType(this.cDK.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajl() != null) {
            this.cDM.eG(dVar.isHost());
            this.cDM.d(dVar);
            this.cDN.setIsHost(dVar.isHost());
            h(dVar);
            this.cDL.a(dVar.isHost(), this.cDK);
            this.cDL.T(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.ajm() == null || dVar.ajm().size() == 0) {
                Uf();
                this.mNoDataView = LayoutInflater.from(this.cDK.getPageContext().getPageActivity()).inflate(d.i.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eH(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.ajm() != null) {
                Iterator<E> it = dVar.ajm().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.ajn()) {
                eH(true);
            }
        }
    }

    public void ajF() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cDL.T(dVar);
        this.cDM.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cDM.f(dVar);
    }

    public void eH(boolean z) {
        this.buU.AI();
        if (z) {
            this.buU.setText(this.cDK.getPageContext().getPageActivity().getResources().getString(d.k.list_no_more));
        } else {
            this.buU.setText("");
        }
    }

    public void Uf() {
        this.buU.dB(0);
    }

    public void ajG() {
        this.buU.AH();
    }

    public void showLoadingView() {
        this.cDK.showLoadingView(this.cDO);
        this.cDO.setVisibility(0);
    }

    public void hideLoadingView() {
        this.cDO.setVisibility(8);
        this.cDK.hideLoadingView(this.cDO);
    }

    public void showErrorView() {
        this.cDO.setVisibility(0);
        this.cDK.showNetRefreshView(this.cDO, this.cDK.getResources().getString(d.k.neterror));
    }

    public void ajH() {
        this.cDO.setVisibility(8);
        this.cDK.hideNetRefreshView(this.cDO);
    }

    public f ajI() {
        return this.cDM;
    }

    public void f(ChannelInfo channelInfo) {
        this.cDM.e(channelInfo);
    }
}
