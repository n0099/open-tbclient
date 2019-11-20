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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class i {
    private BdTypeListView duK;
    private NoNetworkView dvR;
    private PbListView dvS;
    private ChannelHomeActivity eTJ;
    private g eTK;
    private f eTL;
    private com.baidu.tieba.channel.a.c eTM = null;
    private FrameLayout eTN = null;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.eTJ = channelHomeActivity;
        this.eTJ.setIsAddSwipeBackLayout(true);
        this.eTJ.setSwipeBackEnabled(true);
        this.eTJ.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.eTJ.setContentView(R.layout.channel_home_layout);
        this.mRootView = this.eTJ.findViewById(R.id.channel_home_rootview);
        this.eTN = (FrameLayout) this.eTJ.findViewById(R.id.channel_home_loading_view);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.channel_home_no_network_view);
        this.eTK = new g(this.eTJ.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(R.id.channel_home_navigation_bar), this.eTJ);
        aJN();
    }

    private void aJN() {
        this.duK = (BdTypeListView) this.mRootView.findViewById(R.id.channel_home_listview);
        this.eTL = new f(this.eTJ.getPageContext().getPageActivity(), this.eTJ);
        this.duK.addHeaderView(this.eTL.aMv());
        this.eTM = new com.baidu.tieba.channel.a.c(this.eTJ.getPageContext().getPageActivity(), this.duK);
        this.eTM.a(this.eTJ);
        this.duK.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.duK.setOnSrollToBottomListener(this.eTJ);
        this.dvS = new PbListView(this.eTJ.getPageContext().getPageActivity());
        this.dvS.createView();
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
        this.duK.setNextPage(this.dvS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.eTL != null) {
            int dimension = (int) this.eTJ.getResources().getDimension(R.dimen.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.eTJ.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int bby = this.eTL.bby() - (i4 + (-this.eTL.aMv().getTop()));
            if (this.eTK != null) {
                this.eTK.H(bby, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (bbE() != null && bbE().aMv() != null) {
            this.eTJ.getLayoutMode().setNightMode(i == 1);
            this.eTJ.getLayoutMode().onModeChanged(bbE().aMv());
        }
        aaO();
        this.eTL.onChangeSkinType(i);
        this.eTK.onChangeSkinType(i);
        this.dvS.changeSkin(i);
        this.dvR.onChangeSkinType(this.eTJ.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbj() != null) {
            this.eTL.iT(dVar.isHost());
            this.eTL.d(dVar);
            this.eTM.setIsHost(dVar.isHost());
            h(dVar);
            this.eTK.a(dVar.isHost(), this.eTJ);
            this.eTK.al(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.bbk() == null || dVar.bbk().size() == 0) {
                aKi();
                this.mNoDataView = LayoutInflater.from(this.eTJ.getPageContext().getPageActivity()).inflate(R.layout.channel_home_no_data, (ViewGroup) null);
                this.duK.setNoData(this.mNoDataView);
            } else {
                this.duK.setNoData((View) null);
                iU(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.bbk() != null) {
                Iterator<E> it = dVar.bbk().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.duK.setData(arrayList);
            if (!dVar.bbl()) {
                iU(true);
            }
        }
    }

    public void aaO() {
        if (this.duK.getAdapter() != null && (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eTK.al(dVar);
        this.eTL.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.eTL.f(dVar);
    }

    public void iU(boolean z) {
        this.dvS.endLoadData();
        if (z) {
            this.dvS.setText(this.eTJ.getPageContext().getPageActivity().getResources().getString(R.string.list_no_more));
        } else {
            this.dvS.setText("");
        }
    }

    public void aKi() {
        this.dvS.hideWithoutEmptyView(0);
    }

    public void bbD() {
        this.dvS.startLoadData();
    }

    public void showLoadingView() {
        this.eTJ.showLoadingView(this.eTN);
        this.eTN.setVisibility(0);
    }

    public void hideLoadingView() {
        this.eTN.setVisibility(8);
        this.eTJ.hideLoadingView(this.eTN);
    }

    public void GM() {
        this.eTN.setVisibility(0);
        this.eTJ.showNetRefreshView(this.eTN, this.eTJ.getResources().getString(R.string.neterror));
    }

    public void GN() {
        this.eTN.setVisibility(8);
        this.eTJ.hideNetRefreshView(this.eTN);
    }

    public f bbE() {
        return this.eTL;
    }

    public void f(ChannelInfo channelInfo) {
        this.eTL.e(channelInfo);
    }
}
