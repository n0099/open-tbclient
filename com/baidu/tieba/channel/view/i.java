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
    private NoNetworkView bPl;
    private PbListView bPm;
    private ChannelHomeActivity dfR;
    private g dfS;
    private f dfT;
    private com.baidu.tieba.channel.a.c dfU = null;
    private FrameLayout dfV = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.dfR = channelHomeActivity;
        this.dfR.setIsAddSwipeBackLayout(true);
        this.dfR.setSwipeBackEnabled(true);
        this.dfR.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.dfR.setContentView(e.h.channel_home_layout);
        this.mRootView = this.dfR.findViewById(e.g.channel_home_rootview);
        this.dfV = (FrameLayout) this.dfR.findViewById(e.g.channel_home_loading_view);
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.channel_home_no_network_view);
        this.dfS = new g(this.dfR.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(e.g.channel_home_navigation_bar), this.dfR);
        aaW();
    }

    private void aaW() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.channel_home_listview);
        this.dfT = new f(this.dfR.getPageContext().getPageActivity(), this.dfR);
        this.mListView.addHeaderView(this.dfT.anZ());
        this.dfU = new com.baidu.tieba.channel.a.c(this.dfR.getPageContext().getPageActivity(), this.mListView);
        this.dfU.a(this.dfR);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.dfR);
        this.bPm = new PbListView(this.dfR.getPageContext().getPageActivity());
        this.bPm.oH();
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
        this.mListView.setNextPage(this.bPm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.dfT != null) {
            int dimension = (int) this.dfR.getResources().getDimension(e.C0210e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.dfR.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int arP = this.dfT.arP() - (i4 + (-this.dfT.anZ().getTop()));
            if (this.dfS != null) {
                this.dfS.C(arP, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (arV() != null && arV().anZ() != null) {
            this.dfR.getLayoutMode().setNightMode(i == 1);
            this.dfR.getLayoutMode().onModeChanged(arV().anZ());
        }
        notifyDataChanged();
        this.dfT.onChangeSkinType(i);
        this.dfS.onChangeSkinType(i);
        this.bPm.ey(i);
        this.bPl.onChangeSkinType(this.dfR.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.arB() != null) {
            this.dfT.fH(dVar.isHost());
            this.dfT.d(dVar);
            this.dfU.setIsHost(dVar.isHost());
            h(dVar);
            this.dfS.a(dVar.isHost(), this.dfR);
            this.dfS.Z(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.arC() == null || dVar.arC().size() == 0) {
                abA();
                this.mNoDataView = LayoutInflater.from(this.dfR.getPageContext().getPageActivity()).inflate(e.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                fI(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.arC() != null) {
                Iterator<E> it = dVar.arC().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.arD()) {
                fI(true);
            }
        }
    }

    public void notifyDataChanged() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dfS.Z(dVar);
        this.dfT.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.dfT.f(dVar);
    }

    public void fI(boolean z) {
        this.bPm.Fq();
        if (z) {
            this.bPm.setText(this.dfR.getPageContext().getPageActivity().getResources().getString(e.j.list_no_more));
        } else {
            this.bPm.setText("");
        }
    }

    public void abA() {
        this.bPm.eA(0);
    }

    public void arU() {
        this.bPm.Fp();
    }

    public void showLoadingView() {
        this.dfR.showLoadingView(this.dfV);
        this.dfV.setVisibility(0);
    }

    public void hideLoadingView() {
        this.dfV.setVisibility(8);
        this.dfR.hideLoadingView(this.dfV);
    }

    public void showErrorView() {
        this.dfV.setVisibility(0);
        this.dfR.showNetRefreshView(this.dfV, this.dfR.getResources().getString(e.j.neterror));
    }

    public void hideErrorView() {
        this.dfV.setVisibility(8);
        this.dfR.hideNetRefreshView(this.dfV);
    }

    public f arV() {
        return this.dfT;
    }

    public void f(ChannelInfo channelInfo) {
        this.dfT.e(channelInfo);
    }
}
