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
    private NoNetworkView dnM;
    private PbListView dnN;
    private ChannelHomeActivity eKl;
    private g eKm;
    private f eKn;
    private com.baidu.tieba.channel.a.c eKo = null;
    private FrameLayout eKp = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.eKl = channelHomeActivity;
        this.eKl.setIsAddSwipeBackLayout(true);
        this.eKl.setSwipeBackEnabled(true);
        this.eKl.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.eKl.setContentView(R.layout.channel_home_layout);
        this.mRootView = this.eKl.findViewById(R.id.channel_home_rootview);
        this.eKp = (FrameLayout) this.eKl.findViewById(R.id.channel_home_loading_view);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.channel_home_no_network_view);
        this.eKm = new g(this.eKl.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(R.id.channel_home_navigation_bar), this.eKl);
        aJO();
    }

    private void aJO() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.channel_home_listview);
        this.eKn = new f(this.eKl.getPageContext().getPageActivity(), this.eKl);
        this.mListView.addHeaderView(this.eKn.aWT());
        this.eKo = new com.baidu.tieba.channel.a.c(this.eKl.getPageContext().getPageActivity(), this.mListView);
        this.eKo.a(this.eKl);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.eKl);
        this.dnN = new PbListView(this.eKl.getPageContext().getPageActivity());
        this.dnN.nZ();
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
        this.mListView.setNextPage(this.dnN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.eKn != null) {
            int dimension = (int) this.eKl.getResources().getDimension(R.dimen.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.eKl.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int baR = this.eKn.baR() - (i4 + (-this.eKn.aWT().getTop()));
            if (this.eKm != null) {
                this.eKm.H(baR, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (baX() != null && baX().aWT() != null) {
            this.eKl.getLayoutMode().setNightMode(i == 1);
            this.eKl.getLayoutMode().onModeChanged(baX().aWT());
        }
        VX();
        this.eKn.onChangeSkinType(i);
        this.eKm.onChangeSkinType(i);
        this.dnN.iV(i);
        this.dnM.onChangeSkinType(this.eKl.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.baD() != null) {
            this.eKn.iN(dVar.isHost());
            this.eKn.d(dVar);
            this.eKo.setIsHost(dVar.isHost());
            h(dVar);
            this.eKm.a(dVar.isHost(), this.eKl);
            this.eKm.ao(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.baE() == null || dVar.baE().size() == 0) {
                aKm();
                this.mNoDataView = LayoutInflater.from(this.eKl.getPageContext().getPageActivity()).inflate(R.layout.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                iO(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.baE() != null) {
                Iterator<E> it = dVar.baE().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.baF()) {
                iO(true);
            }
        }
    }

    public void VX() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eKm.ao(dVar);
        this.eKn.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.eKn.f(dVar);
    }

    public void iO(boolean z) {
        this.dnN.akG();
        if (z) {
            this.dnN.setText(this.eKl.getPageContext().getPageActivity().getResources().getString(R.string.list_no_more));
        } else {
            this.dnN.setText("");
        }
    }

    public void aKm() {
        this.dnN.iX(0);
    }

    public void baW() {
        this.dnN.akF();
    }

    public void showLoadingView() {
        this.eKl.showLoadingView(this.eKp);
        this.eKp.setVisibility(0);
    }

    public void hideLoadingView() {
        this.eKp.setVisibility(8);
        this.eKl.hideLoadingView(this.eKp);
    }

    public void BN() {
        this.eKp.setVisibility(0);
        this.eKl.showNetRefreshView(this.eKp, this.eKl.getResources().getString(R.string.neterror));
    }

    public void BO() {
        this.eKp.setVisibility(8);
        this.eKl.hideNetRefreshView(this.eKp);
    }

    public f baX() {
        return this.eKn;
    }

    public void f(ChannelInfo channelInfo) {
        this.eKn.e(channelInfo);
    }
}
