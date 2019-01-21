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
    private NoNetworkView bPm;
    private PbListView bPn;
    private ChannelHomeActivity dfS;
    private g dfT;
    private f dfU;
    private com.baidu.tieba.channel.a.c dfV = null;
    private FrameLayout dfW = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.dfS = channelHomeActivity;
        this.dfS.setIsAddSwipeBackLayout(true);
        this.dfS.setSwipeBackEnabled(true);
        this.dfS.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.dfS.setContentView(e.h.channel_home_layout);
        this.mRootView = this.dfS.findViewById(e.g.channel_home_rootview);
        this.dfW = (FrameLayout) this.dfS.findViewById(e.g.channel_home_loading_view);
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.channel_home_no_network_view);
        this.dfT = new g(this.dfS.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(e.g.channel_home_navigation_bar), this.dfS);
        aaW();
    }

    private void aaW() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.channel_home_listview);
        this.dfU = new f(this.dfS.getPageContext().getPageActivity(), this.dfS);
        this.mListView.addHeaderView(this.dfU.anZ());
        this.dfV = new com.baidu.tieba.channel.a.c(this.dfS.getPageContext().getPageActivity(), this.mListView);
        this.dfV.a(this.dfS);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.dfS);
        this.bPn = new PbListView(this.dfS.getPageContext().getPageActivity());
        this.bPn.oH();
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
        this.mListView.setNextPage(this.bPn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.dfU != null) {
            int dimension = (int) this.dfS.getResources().getDimension(e.C0210e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.dfS.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int arP = this.dfU.arP() - (i4 + (-this.dfU.anZ().getTop()));
            if (this.dfT != null) {
                this.dfT.C(arP, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (arV() != null && arV().anZ() != null) {
            this.dfS.getLayoutMode().setNightMode(i == 1);
            this.dfS.getLayoutMode().onModeChanged(arV().anZ());
        }
        notifyDataChanged();
        this.dfU.onChangeSkinType(i);
        this.dfT.onChangeSkinType(i);
        this.bPn.ey(i);
        this.bPm.onChangeSkinType(this.dfS.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.arB() != null) {
            this.dfU.fH(dVar.isHost());
            this.dfU.d(dVar);
            this.dfV.setIsHost(dVar.isHost());
            h(dVar);
            this.dfT.a(dVar.isHost(), this.dfS);
            this.dfT.Z(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.arC() == null || dVar.arC().size() == 0) {
                abA();
                this.mNoDataView = LayoutInflater.from(this.dfS.getPageContext().getPageActivity()).inflate(e.h.channel_home_no_data, (ViewGroup) null);
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
        this.dfT.Z(dVar);
        this.dfU.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.dfU.f(dVar);
    }

    public void fI(boolean z) {
        this.bPn.Fq();
        if (z) {
            this.bPn.setText(this.dfS.getPageContext().getPageActivity().getResources().getString(e.j.list_no_more));
        } else {
            this.bPn.setText("");
        }
    }

    public void abA() {
        this.bPn.eA(0);
    }

    public void arU() {
        this.bPn.Fp();
    }

    public void showLoadingView() {
        this.dfS.showLoadingView(this.dfW);
        this.dfW.setVisibility(0);
    }

    public void hideLoadingView() {
        this.dfW.setVisibility(8);
        this.dfS.hideLoadingView(this.dfW);
    }

    public void showErrorView() {
        this.dfW.setVisibility(0);
        this.dfS.showNetRefreshView(this.dfW, this.dfS.getResources().getString(e.j.neterror));
    }

    public void hideErrorView() {
        this.dfW.setVisibility(8);
        this.dfS.hideNetRefreshView(this.dfW);
    }

    public f arV() {
        return this.dfU;
    }

    public void f(ChannelInfo channelInfo) {
        this.dfU.e(channelInfo);
    }
}
