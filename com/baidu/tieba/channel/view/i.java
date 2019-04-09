package com.baidu.tieba.channel.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
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
/* loaded from: classes6.dex */
public class i {
    private NoNetworkView dbr;
    private PbListView dbs;
    private ChannelHomeActivity epA;
    private g epB;
    private f epC;
    private com.baidu.tieba.channel.a.c epD = null;
    private FrameLayout epE = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.epA = channelHomeActivity;
        this.epA.setIsAddSwipeBackLayout(true);
        this.epA.setSwipeBackEnabled(true);
        this.epA.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.epA.setContentView(d.h.channel_home_layout);
        this.mRootView = this.epA.findViewById(d.g.channel_home_rootview);
        this.epE = (FrameLayout) this.epA.findViewById(d.g.channel_home_loading_view);
        this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.epB = new g(this.epA.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.epA);
        aBW();
    }

    private void aBW() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.epC = new f(this.epA.getPageContext().getPageActivity(), this.epA);
        this.mListView.addHeaderView(this.epC.aOH());
        this.epD = new com.baidu.tieba.channel.a.c(this.epA.getPageContext().getPageActivity(), this.mListView);
        this.epD.a(this.epA);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.epA);
        this.dbs = new PbListView(this.epA.getPageContext().getPageActivity());
        this.dbs.oM();
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.mListView.setNextPage(this.dbs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.epC != null) {
            int dimension = (int) this.epA.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.epA.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aRE = this.epC.aRE() - (i4 + (-this.epC.aOH().getTop()));
            if (this.epB != null) {
                this.epB.F(aRE, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (aRK() != null && aRK().aOH() != null) {
            this.epA.getLayoutMode().setNightMode(i == 1);
            this.epA.getLayoutMode().onModeChanged(aRK().aOH());
        }
        Rs();
        this.epC.onChangeSkinType(i);
        this.epB.onChangeSkinType(i);
        this.dbs.ib(i);
        this.dbr.onChangeSkinType(this.epA.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aRq() != null) {
            this.epC.hZ(dVar.isHost());
            this.epC.d(dVar);
            this.epD.setIsHost(dVar.isHost());
            h(dVar);
            this.epB.a(dVar.isHost(), this.epA);
            this.epB.am(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aRr() == null || dVar.aRr().size() == 0) {
                aCt();
                this.mNoDataView = LayoutInflater.from(this.epA.getPageContext().getPageActivity()).inflate(d.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                ia(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aRr() != null) {
                Iterator<E> it = dVar.aRr().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aRs()) {
                ia(true);
            }
        }
    }

    public void Rs() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.epB.am(dVar);
        this.epC.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.epC.f(dVar);
    }

    public void ia(boolean z) {
        this.dbs.aeA();
        if (z) {
            this.dbs.setText(this.epA.getPageContext().getPageActivity().getResources().getString(d.j.list_no_more));
        } else {
            this.dbs.setText("");
        }
    }

    public void aCt() {
        this.dbs.id(0);
    }

    public void aRJ() {
        this.dbs.aez();
    }

    public void showLoadingView() {
        this.epA.showLoadingView(this.epE);
        this.epE.setVisibility(0);
    }

    public void hideLoadingView() {
        this.epE.setVisibility(8);
        this.epA.hideLoadingView(this.epE);
    }

    public void zX() {
        this.epE.setVisibility(0);
        this.epA.showNetRefreshView(this.epE, this.epA.getResources().getString(d.j.neterror));
    }

    public void zY() {
        this.epE.setVisibility(8);
        this.epA.hideNetRefreshView(this.epE);
    }

    public f aRK() {
        return this.epC;
    }

    public void f(ChannelInfo channelInfo) {
        this.epC.e(channelInfo);
    }
}
