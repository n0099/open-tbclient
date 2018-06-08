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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class i {
    private NoNetworkView btu;
    private PbListView btv;
    private ChannelHomeActivity cFR;
    private g cFS;
    private f cFT;
    private com.baidu.tieba.channel.a.c cFU = null;
    private FrameLayout cFV = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cFR = channelHomeActivity;
        this.cFR.setIsAddSwipeBackLayout(true);
        this.cFR.setSwipeBackEnabled(true);
        this.cFR.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cFR.setContentView(d.i.channel_home_layout);
        this.mRootView = this.cFR.findViewById(d.g.channel_home_rootview);
        this.cFV = (FrameLayout) this.cFR.findViewById(d.g.channel_home_loading_view);
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.cFS = new g(this.cFR.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.cFR);
        Th();
    }

    private void Th() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.cFT = new f(this.cFR.getPageContext().getPageActivity(), this.cFR);
        this.mListView.addHeaderView(this.cFT.aga());
        this.cFU = new com.baidu.tieba.channel.a.c(this.cFR.getPageContext().getPageActivity(), this.mListView);
        this.cFU.a(this.cFR);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cFR);
        this.btv = new PbListView(this.cFR.getPageContext().getPageActivity());
        this.btv.nn();
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
        this.mListView.setNextPage(this.btv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cFT != null) {
            int dimension = (int) this.cFR.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cFR.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int akg = this.cFT.akg() - (i4 + (-this.cFT.aga().getTop()));
            if (this.cFS != null) {
                this.cFS.x(akg, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (ako() != null && ako().aga() != null) {
            this.cFR.getLayoutMode().setNightMode(i == 1);
            this.cFR.getLayoutMode().onModeChanged(ako().aga());
        }
        akl();
        this.cFT.onChangeSkinType(i);
        this.cFS.onChangeSkinType(i);
        this.btv.dy(i);
        this.btu.onChangeSkinType(this.cFR.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajR() != null) {
            this.cFT.eG(dVar.isHost());
            this.cFT.d(dVar);
            this.cFU.setIsHost(dVar.isHost());
            h(dVar);
            this.cFS.a(dVar.isHost(), this.cFR);
            this.cFS.R(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.ajS() == null || dVar.ajS().size() == 0) {
                TL();
                this.mNoDataView = LayoutInflater.from(this.cFR.getPageContext().getPageActivity()).inflate(d.i.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eH(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.ajS() != null) {
                Iterator<E> it = dVar.ajS().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.ajT()) {
                eH(true);
            }
        }
    }

    public void akl() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cFS.R(dVar);
        this.cFT.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cFT.f(dVar);
    }

    public void eH(boolean z) {
        this.btv.As();
        if (z) {
            this.btv.setText(this.cFR.getPageContext().getPageActivity().getResources().getString(d.k.list_no_more));
        } else {
            this.btv.setText("");
        }
    }

    public void TL() {
        this.btv.dA(0);
    }

    public void akm() {
        this.btv.Ar();
    }

    public void showLoadingView() {
        this.cFR.showLoadingView(this.cFV);
        this.cFV.setVisibility(0);
    }

    public void hideLoadingView() {
        this.cFV.setVisibility(8);
        this.cFR.hideLoadingView(this.cFV);
    }

    public void showErrorView() {
        this.cFV.setVisibility(0);
        this.cFR.showNetRefreshView(this.cFV, this.cFR.getResources().getString(d.k.neterror));
    }

    public void akn() {
        this.cFV.setVisibility(8);
        this.cFR.hideNetRefreshView(this.cFV);
    }

    public f ako() {
        return this.cFT;
    }

    public void f(ChannelInfo channelInfo) {
        this.cFT.e(channelInfo);
    }
}
