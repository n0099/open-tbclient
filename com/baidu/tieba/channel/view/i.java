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
    private NoNetworkView bOx;
    private PbListView bOy;
    private ChannelHomeActivity dcm;
    private g dcn;
    private f dco;
    private com.baidu.tieba.channel.a.c dcp = null;
    private FrameLayout dcq = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.dcm = channelHomeActivity;
        this.dcm.setIsAddSwipeBackLayout(true);
        this.dcm.setSwipeBackEnabled(true);
        this.dcm.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.dcm.setContentView(e.h.channel_home_layout);
        this.mRootView = this.dcm.findViewById(e.g.channel_home_rootview);
        this.dcq = (FrameLayout) this.dcm.findViewById(e.g.channel_home_loading_view);
        this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.channel_home_no_network_view);
        this.dcn = new g(this.dcm.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(e.g.channel_home_navigation_bar), this.dcm);
        aax();
    }

    private void aax() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.channel_home_listview);
        this.dco = new f(this.dcm.getPageContext().getPageActivity(), this.dcm);
        this.mListView.addHeaderView(this.dco.ana());
        this.dcp = new com.baidu.tieba.channel.a.c(this.dcm.getPageContext().getPageActivity(), this.mListView);
        this.dcp.a(this.dcm);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.dcm);
        this.bOy = new PbListView(this.dcm.getPageContext().getPageActivity());
        this.bOy.oD();
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
        this.mListView.setNextPage(this.bOy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.dco != null) {
            int dimension = (int) this.dcm.getResources().getDimension(e.C0210e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.dcm.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aqC = this.dco.aqC() - (i4 + (-this.dco.ana().getTop()));
            if (this.dcn != null) {
                this.dcn.C(aqC, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (aqI() != null && aqI().ana() != null) {
            this.dcm.getLayoutMode().setNightMode(i == 1);
            this.dcm.getLayoutMode().onModeChanged(aqI().ana());
        }
        notifyDataChanged();
        this.dco.onChangeSkinType(i);
        this.dcn.onChangeSkinType(i);
        this.bOy.ey(i);
        this.bOx.onChangeSkinType(this.dcm.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aqo() != null) {
            this.dco.fC(dVar.isHost());
            this.dco.d(dVar);
            this.dcp.setIsHost(dVar.isHost());
            h(dVar);
            this.dcn.a(dVar.isHost(), this.dcm);
            this.dcn.Z(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aqp() == null || dVar.aqp().size() == 0) {
                abb();
                this.mNoDataView = LayoutInflater.from(this.dcm.getPageContext().getPageActivity()).inflate(e.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                fD(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aqp() != null) {
                Iterator<E> it = dVar.aqp().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aqq()) {
                fD(true);
            }
        }
    }

    public void notifyDataChanged() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dcn.Z(dVar);
        this.dco.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.dco.f(dVar);
    }

    public void fD(boolean z) {
        this.bOy.Fd();
        if (z) {
            this.bOy.setText(this.dcm.getPageContext().getPageActivity().getResources().getString(e.j.list_no_more));
        } else {
            this.bOy.setText("");
        }
    }

    public void abb() {
        this.bOy.eA(0);
    }

    public void aqH() {
        this.bOy.Fc();
    }

    public void showLoadingView() {
        this.dcm.showLoadingView(this.dcq);
        this.dcq.setVisibility(0);
    }

    public void hideLoadingView() {
        this.dcq.setVisibility(8);
        this.dcm.hideLoadingView(this.dcq);
    }

    public void showErrorView() {
        this.dcq.setVisibility(0);
        this.dcm.showNetRefreshView(this.dcq, this.dcm.getResources().getString(e.j.neterror));
    }

    public void hideErrorView() {
        this.dcq.setVisibility(8);
        this.dcm.hideNetRefreshView(this.dcq);
    }

    public f aqI() {
        return this.dco;
    }

    public void f(ChannelInfo channelInfo) {
        this.dco.e(channelInfo);
    }
}
