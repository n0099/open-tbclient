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
    private NoNetworkView dbm;
    private PbListView dbn;
    private ChannelHomeActivity epN;
    private g epO;
    private f epP;
    private com.baidu.tieba.channel.a.c epQ = null;
    private FrameLayout epR = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.epN = channelHomeActivity;
        this.epN.setIsAddSwipeBackLayout(true);
        this.epN.setSwipeBackEnabled(true);
        this.epN.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.epN.setContentView(d.h.channel_home_layout);
        this.mRootView = this.epN.findViewById(d.g.channel_home_rootview);
        this.epR = (FrameLayout) this.epN.findViewById(d.g.channel_home_loading_view);
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.epO = new g(this.epN.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.epN);
        aBZ();
    }

    private void aBZ() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.epP = new f(this.epN.getPageContext().getPageActivity(), this.epN);
        this.mListView.addHeaderView(this.epP.aOM());
        this.epQ = new com.baidu.tieba.channel.a.c(this.epN.getPageContext().getPageActivity(), this.mListView);
        this.epQ.a(this.epN);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.epN);
        this.dbn = new PbListView(this.epN.getPageContext().getPageActivity());
        this.dbn.oM();
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.mListView.setNextPage(this.dbn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.epP != null) {
            int dimension = (int) this.epN.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.epN.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aRG = this.epP.aRG() - (i4 + (-this.epP.aOM().getTop()));
            if (this.epO != null) {
                this.epO.F(aRG, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (aRM() != null && aRM().aOM() != null) {
            this.epN.getLayoutMode().setNightMode(i == 1);
            this.epN.getLayoutMode().onModeChanged(aRM().aOM());
        }
        Ru();
        this.epP.onChangeSkinType(i);
        this.epO.onChangeSkinType(i);
        this.dbn.ic(i);
        this.dbm.onChangeSkinType(this.epN.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aRs() != null) {
            this.epP.hZ(dVar.isHost());
            this.epP.d(dVar);
            this.epQ.setIsHost(dVar.isHost());
            h(dVar);
            this.epO.a(dVar.isHost(), this.epN);
            this.epO.aq(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aRt() == null || dVar.aRt().size() == 0) {
                aCw();
                this.mNoDataView = LayoutInflater.from(this.epN.getPageContext().getPageActivity()).inflate(d.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                ia(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aRt() != null) {
                Iterator<E> it = dVar.aRt().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aRu()) {
                ia(true);
            }
        }
    }

    public void Ru() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.epO.aq(dVar);
        this.epP.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.epP.f(dVar);
    }

    public void ia(boolean z) {
        this.dbn.aeD();
        if (z) {
            this.dbn.setText(this.epN.getPageContext().getPageActivity().getResources().getString(d.j.list_no_more));
        } else {
            this.dbn.setText("");
        }
    }

    public void aCw() {
        this.dbn.ie(0);
    }

    public void aRL() {
        this.dbn.aeC();
    }

    public void showLoadingView() {
        this.epN.showLoadingView(this.epR);
        this.epR.setVisibility(0);
    }

    public void hideLoadingView() {
        this.epR.setVisibility(8);
        this.epN.hideLoadingView(this.epR);
    }

    public void zY() {
        this.epR.setVisibility(0);
        this.epN.showNetRefreshView(this.epR, this.epN.getResources().getString(d.j.neterror));
    }

    public void zZ() {
        this.epR.setVisibility(8);
        this.epN.hideNetRefreshView(this.epR);
    }

    public f aRM() {
        return this.epP;
    }

    public void f(ChannelInfo channelInfo) {
        this.epP.e(channelInfo);
    }
}
