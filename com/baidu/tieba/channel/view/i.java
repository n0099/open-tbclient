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
    private BdTypeListView dvB;
    private NoNetworkView dwI;
    private PbListView dwJ;
    private ChannelHomeActivity eUA;
    private g eUB;
    private f eUC;
    private com.baidu.tieba.channel.a.c eUD = null;
    private FrameLayout eUE = null;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.eUA = channelHomeActivity;
        this.eUA.setIsAddSwipeBackLayout(true);
        this.eUA.setSwipeBackEnabled(true);
        this.eUA.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.eUA.setContentView(R.layout.channel_home_layout);
        this.mRootView = this.eUA.findViewById(R.id.channel_home_rootview);
        this.eUE = (FrameLayout) this.eUA.findViewById(R.id.channel_home_loading_view);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.channel_home_no_network_view);
        this.eUB = new g(this.eUA.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(R.id.channel_home_navigation_bar), this.eUA);
        aJP();
    }

    private void aJP() {
        this.dvB = (BdTypeListView) this.mRootView.findViewById(R.id.channel_home_listview);
        this.eUC = new f(this.eUA.getPageContext().getPageActivity(), this.eUA);
        this.dvB.addHeaderView(this.eUC.aMx());
        this.eUD = new com.baidu.tieba.channel.a.c(this.eUA.getPageContext().getPageActivity(), this.dvB);
        this.eUD.a(this.eUA);
        this.dvB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.dvB.setOnSrollToBottomListener(this.eUA);
        this.dwJ = new PbListView(this.eUA.getPageContext().getPageActivity());
        this.dwJ.createView();
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dvB.setNextPage(this.dwJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.eUC != null) {
            int dimension = (int) this.eUA.getResources().getDimension(R.dimen.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.eUA.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int bbA = this.eUC.bbA() - (i4 + (-this.eUC.aMx().getTop()));
            if (this.eUB != null) {
                this.eUB.H(bbA, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (bbG() != null && bbG().aMx() != null) {
            this.eUA.getLayoutMode().setNightMode(i == 1);
            this.eUA.getLayoutMode().onModeChanged(bbG().aMx());
        }
        aaQ();
        this.eUC.onChangeSkinType(i);
        this.eUB.onChangeSkinType(i);
        this.dwJ.changeSkin(i);
        this.dwI.onChangeSkinType(this.eUA.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbl() != null) {
            this.eUC.iT(dVar.isHost());
            this.eUC.d(dVar);
            this.eUD.setIsHost(dVar.isHost());
            h(dVar);
            this.eUB.a(dVar.isHost(), this.eUA);
            this.eUB.al(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.bbm() == null || dVar.bbm().size() == 0) {
                aKk();
                this.mNoDataView = LayoutInflater.from(this.eUA.getPageContext().getPageActivity()).inflate(R.layout.channel_home_no_data, (ViewGroup) null);
                this.dvB.setNoData(this.mNoDataView);
            } else {
                this.dvB.setNoData((View) null);
                iU(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.bbm() != null) {
                Iterator<E> it = dVar.bbm().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.dvB.setData(arrayList);
            if (!dVar.bbn()) {
                iU(true);
            }
        }
    }

    public void aaQ() {
        if (this.dvB.getAdapter() != null && (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eUB.al(dVar);
        this.eUC.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.eUC.f(dVar);
    }

    public void iU(boolean z) {
        this.dwJ.endLoadData();
        if (z) {
            this.dwJ.setText(this.eUA.getPageContext().getPageActivity().getResources().getString(R.string.list_no_more));
        } else {
            this.dwJ.setText("");
        }
    }

    public void aKk() {
        this.dwJ.hideWithoutEmptyView(0);
    }

    public void bbF() {
        this.dwJ.startLoadData();
    }

    public void showLoadingView() {
        this.eUA.showLoadingView(this.eUE);
        this.eUE.setVisibility(0);
    }

    public void hideLoadingView() {
        this.eUE.setVisibility(8);
        this.eUA.hideLoadingView(this.eUE);
    }

    public void GL() {
        this.eUE.setVisibility(0);
        this.eUA.showNetRefreshView(this.eUE, this.eUA.getResources().getString(R.string.neterror));
    }

    public void GM() {
        this.eUE.setVisibility(8);
        this.eUA.hideNetRefreshView(this.eUE);
    }

    public f bbG() {
        return this.eUC;
    }

    public void f(ChannelInfo channelInfo) {
        this.eUC.e(channelInfo);
    }
}
