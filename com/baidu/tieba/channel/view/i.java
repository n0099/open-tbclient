package com.baidu.tieba.channel.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
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
    private NoNetworkView caX;
    private PbListView caY;
    private ChannelHomeActivity deo;
    private g dep;
    private f deq;
    private com.baidu.tieba.channel.a.c der = null;
    private FrameLayout det = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.deo = channelHomeActivity;
        this.deo.setIsAddSwipeBackLayout(true);
        this.deo.setSwipeBackEnabled(true);
        this.deo.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.deo.setContentView(d.h.channel_home_layout);
        this.mRootView = this.deo.findViewById(d.g.channel_home_rootview);
        this.det = (FrameLayout) this.deo.findViewById(d.g.channel_home_loading_view);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.dep = new g(this.deo.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.deo);
        Xl();
    }

    private void Xl() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.deq = new f(this.deo.getPageContext().getPageActivity(), this.deo);
        this.mListView.addHeaderView(this.deq.aiw());
        this.der = new com.baidu.tieba.channel.a.c(this.deo.getPageContext().getPageActivity(), this.mListView);
        this.der.a(this.deo);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.deo);
        this.caY = new PbListView(this.deo.getPageContext().getPageActivity());
        this.caY.st();
        this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
        this.mListView.setNextPage(this.caY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.deq != null) {
            int dimension = (int) this.deo.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.deo.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int amx = this.deq.amx() - (i4 + (-this.deq.aiw().getTop()));
            if (this.dep != null) {
                this.dep.J(amx, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (amG() != null && amG().aiw() != null) {
            this.deo.getLayoutMode().aQ(i == 1);
            this.deo.getLayoutMode().aM(amG().aiw());
        }
        amC();
        this.deq.onChangeSkinType(i);
        this.dep.onChangeSkinType(i);
        this.caY.gx(i);
        this.caX.onChangeSkinType(this.deo.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ami() != null) {
            this.deq.eW(dVar.isHost());
            this.deq.d(dVar);
            this.der.setIsHost(dVar.isHost());
            h(dVar);
            this.dep.a(dVar.isHost(), this.deo);
            this.dep.aT(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.amj() == null || dVar.amj().size() == 0) {
                XP();
                this.mNoDataView = LayoutInflater.from(this.deo.getPageContext().getPageActivity()).inflate(d.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eX(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.amj() != null) {
                Iterator<E> it = dVar.amj().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.i) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.amk()) {
                eX(true);
            }
        }
    }

    public void amC() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dep.aT(dVar);
        this.deq.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.deq.f(dVar);
    }

    public void eX(boolean z) {
        this.caY.Eg();
        if (z) {
            this.caY.setText(this.deo.getPageContext().getPageActivity().getResources().getString(d.j.list_no_more));
        } else {
            this.caY.setText("");
        }
    }

    public void XP() {
        this.caY.gz(0);
    }

    public void amD() {
        this.caY.Ef();
    }

    public void VT() {
        this.deo.showLoadingView(this.det);
        this.det.setVisibility(0);
    }

    public void VU() {
        this.det.setVisibility(8);
        this.deo.hideLoadingView(this.det);
    }

    public void amE() {
        this.det.setVisibility(0);
        this.deo.showNetRefreshView(this.det, this.deo.getResources().getString(d.j.neterror));
    }

    public void amF() {
        this.det.setVisibility(8);
        this.deo.hideNetRefreshView(this.det);
    }

    public f amG() {
        return this.deq;
    }

    public void f(ChannelInfo channelInfo) {
        this.deq.e(channelInfo);
    }
}
