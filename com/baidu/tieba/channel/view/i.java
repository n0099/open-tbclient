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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class i {
    private NoNetworkView bvB;
    private PbListView bvC;
    private ChannelHomeActivity cGn;
    private g cGo;
    private f cGp;
    private com.baidu.tieba.channel.a.c cGq = null;
    private FrameLayout cGr = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cGn = channelHomeActivity;
        this.cGn.setIsAddSwipeBackLayout(true);
        this.cGn.setSwipeBackEnabled(true);
        this.cGn.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cGn.setContentView(f.h.channel_home_layout);
        this.mRootView = this.cGn.findViewById(f.g.channel_home_rootview);
        this.cGr = (FrameLayout) this.cGn.findViewById(f.g.channel_home_loading_view);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.channel_home_no_network_view);
        this.cGo = new g(this.cGn.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(f.g.channel_home_navigation_bar), this.cGn);
        TM();
    }

    private void TM() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(f.g.channel_home_listview);
        this.cGp = new f(this.cGn.getPageContext().getPageActivity(), this.cGn);
        this.mListView.addHeaderView(this.cGp.ahd());
        this.cGq = new com.baidu.tieba.channel.a.c(this.cGn.getPageContext().getPageActivity(), this.mListView);
        this.cGq.a(this.cGn);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cGn);
        this.bvC = new PbListView(this.cGn.getPageContext().getPageActivity());
        this.bvC.np();
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
        this.mListView.setNextPage(this.bvC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cGp != null) {
            int dimension = (int) this.cGn.getResources().getDimension(f.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cGn.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aka = this.cGp.aka() - (i4 + (-this.cGp.ahd().getTop()));
            if (this.cGo != null) {
                this.cGo.x(aka, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (akj() != null && akj().ahd() != null) {
            this.cGn.getLayoutMode().setNightMode(i == 1);
            this.cGn.getLayoutMode().onModeChanged(akj().ahd());
        }
        akf();
        this.cGp.onChangeSkinType(i);
        this.cGo.onChangeSkinType(i);
        this.bvC.dB(i);
        this.bvB.onChangeSkinType(this.cGn.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajM() != null) {
            this.cGp.eH(dVar.isHost());
            this.cGp.d(dVar);
            this.cGq.setIsHost(dVar.isHost());
            h(dVar);
            this.cGo.a(dVar.isHost(), this.cGn);
            this.cGo.T(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.ajN() == null || dVar.ajN().size() == 0) {
                Uq();
                this.mNoDataView = LayoutInflater.from(this.cGn.getPageContext().getPageActivity()).inflate(f.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eI(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.ajN() != null) {
                Iterator<E> it = dVar.ajN().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.ajO()) {
                eI(true);
            }
        }
    }

    public void akf() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cGo.T(dVar);
        this.cGp.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cGp.f(dVar);
    }

    public void eI(boolean z) {
        this.bvC.Aw();
        if (z) {
            this.bvC.setText(this.cGn.getPageContext().getPageActivity().getResources().getString(f.j.list_no_more));
        } else {
            this.bvC.setText("");
        }
    }

    public void Uq() {
        this.bvC.dD(0);
    }

    public void akg() {
        this.bvC.Av();
    }

    public void showLoadingView() {
        this.cGn.showLoadingView(this.cGr);
        this.cGr.setVisibility(0);
    }

    public void hideLoadingView() {
        this.cGr.setVisibility(8);
        this.cGn.hideLoadingView(this.cGr);
    }

    public void akh() {
        this.cGr.setVisibility(0);
        this.cGn.showNetRefreshView(this.cGr, this.cGn.getResources().getString(f.j.neterror));
    }

    public void aki() {
        this.cGr.setVisibility(8);
        this.cGn.hideNetRefreshView(this.cGr);
    }

    public f akj() {
        return this.cGp;
    }

    public void f(ChannelInfo channelInfo) {
        this.cGp.e(channelInfo);
    }
}
