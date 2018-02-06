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
    private NoNetworkView cbj;
    private PbListView cbk;
    private ChannelHomeActivity deB;
    private g deC;
    private f deD;
    private com.baidu.tieba.channel.a.c deE = null;
    private FrameLayout deF = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.deB = channelHomeActivity;
        this.deB.setIsAddSwipeBackLayout(true);
        this.deB.setSwipeBackEnabled(true);
        this.deB.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.deB.setContentView(d.h.channel_home_layout);
        this.mRootView = this.deB.findViewById(d.g.channel_home_rootview);
        this.deF = (FrameLayout) this.deB.findViewById(d.g.channel_home_loading_view);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.deC = new g(this.deB.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.deB);
        Xm();
    }

    private void Xm() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.deD = new f(this.deB.getPageContext().getPageActivity(), this.deB);
        this.mListView.addHeaderView(this.deD.aix());
        this.deE = new com.baidu.tieba.channel.a.c(this.deB.getPageContext().getPageActivity(), this.mListView);
        this.deE.a(this.deB);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.deB);
        this.cbk = new PbListView(this.deB.getPageContext().getPageActivity());
        this.cbk.st();
        this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
        this.mListView.setNextPage(this.cbk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.deD != null) {
            int dimension = (int) this.deB.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.deB.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int amy = this.deD.amy() - (i4 + (-this.deD.aix().getTop()));
            if (this.deC != null) {
                this.deC.J(amy, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (amH() != null && amH().aix() != null) {
            this.deB.getLayoutMode().aQ(i == 1);
            this.deB.getLayoutMode().aM(amH().aix());
        }
        amD();
        this.deD.onChangeSkinType(i);
        this.deC.onChangeSkinType(i);
        this.cbk.gx(i);
        this.cbj.onChangeSkinType(this.deB.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.amj() != null) {
            this.deD.eW(dVar.isHost());
            this.deD.d(dVar);
            this.deE.setIsHost(dVar.isHost());
            h(dVar);
            this.deC.a(dVar.isHost(), this.deB);
            this.deC.aT(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.amk() == null || dVar.amk().size() == 0) {
                XQ();
                this.mNoDataView = LayoutInflater.from(this.deB.getPageContext().getPageActivity()).inflate(d.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eX(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.amk() != null) {
                Iterator<E> it = dVar.amk().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.i) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aml()) {
                eX(true);
            }
        }
    }

    public void amD() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.deC.aT(dVar);
        this.deD.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.deD.f(dVar);
    }

    public void eX(boolean z) {
        this.cbk.Eh();
        if (z) {
            this.cbk.setText(this.deB.getPageContext().getPageActivity().getResources().getString(d.j.list_no_more));
        } else {
            this.cbk.setText("");
        }
    }

    public void XQ() {
        this.cbk.gz(0);
    }

    public void amE() {
        this.cbk.Eg();
    }

    public void VU() {
        this.deB.showLoadingView(this.deF);
        this.deF.setVisibility(0);
    }

    public void VV() {
        this.deF.setVisibility(8);
        this.deB.hideLoadingView(this.deF);
    }

    public void amF() {
        this.deF.setVisibility(0);
        this.deB.showNetRefreshView(this.deF, this.deB.getResources().getString(d.j.neterror));
    }

    public void amG() {
        this.deF.setVisibility(8);
        this.deB.hideNetRefreshView(this.deF);
    }

    public f amH() {
        return this.deD;
    }

    public void f(ChannelInfo channelInfo) {
        this.deD.e(channelInfo);
    }
}
