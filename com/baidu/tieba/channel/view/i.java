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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class i {
    private NoNetworkView dlX;
    private PbListView dlY;
    private ChannelHomeActivity eFi;
    private g eFj;
    private f eFk;
    private com.baidu.tieba.channel.a.c eFl = null;
    private FrameLayout eFm = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.eFi = channelHomeActivity;
        this.eFi.setIsAddSwipeBackLayout(true);
        this.eFi.setSwipeBackEnabled(true);
        this.eFi.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.eFi.setContentView(R.layout.channel_home_layout);
        this.mRootView = this.eFi.findViewById(R.id.channel_home_rootview);
        this.eFm = (FrameLayout) this.eFi.findViewById(R.id.channel_home_loading_view);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.channel_home_no_network_view);
        this.eFj = new g(this.eFi.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(R.id.channel_home_navigation_bar), this.eFi);
        aIn();
    }

    private void aIn() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.channel_home_listview);
        this.eFk = new f(this.eFi.getPageContext().getPageActivity(), this.eFi);
        this.mListView.addHeaderView(this.eFk.aUW());
        this.eFl = new com.baidu.tieba.channel.a.c(this.eFi.getPageContext().getPageActivity(), this.mListView);
        this.eFl.a(this.eFi);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.eFi);
        this.dlY = new PbListView(this.eFi.getPageContext().getPageActivity());
        this.dlY.nG();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
        this.mListView.setNextPage(this.dlY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.eFk != null) {
            int dimension = (int) this.eFi.getResources().getDimension(R.dimen.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.eFi.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aYQ = this.eFk.aYQ() - (i4 + (-this.eFk.aUW().getTop()));
            if (this.eFj != null) {
                this.eFj.G(aYQ, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (aYW() != null && aYW().aUW() != null) {
            this.eFi.getLayoutMode().setNightMode(i == 1);
            this.eFi.getLayoutMode().onModeChanged(aYW().aUW());
        }
        Ve();
        this.eFk.onChangeSkinType(i);
        this.eFj.onChangeSkinType(i);
        this.dlY.iP(i);
        this.dlX.onChangeSkinType(this.eFi.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aYC() != null) {
            this.eFk.iE(dVar.isHost());
            this.eFk.d(dVar);
            this.eFl.setIsHost(dVar.isHost());
            h(dVar);
            this.eFj.a(dVar.isHost(), this.eFi);
            this.eFj.ao(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aYD() == null || dVar.aYD().size() == 0) {
                aIJ();
                this.mNoDataView = LayoutInflater.from(this.eFi.getPageContext().getPageActivity()).inflate(R.layout.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                iF(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aYD() != null) {
                Iterator<E> it = dVar.aYD().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aYE()) {
                iF(true);
            }
        }
    }

    public void Ve() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eFj.ao(dVar);
        this.eFk.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.eFk.f(dVar);
    }

    public void iF(boolean z) {
        this.dlY.ajz();
        if (z) {
            this.dlY.setText(this.eFi.getPageContext().getPageActivity().getResources().getString(R.string.list_no_more));
        } else {
            this.dlY.setText("");
        }
    }

    public void aIJ() {
        this.dlY.iR(0);
    }

    public void aYV() {
        this.dlY.ajy();
    }

    public void showLoadingView() {
        this.eFi.showLoadingView(this.eFm);
        this.eFm.setVisibility(0);
    }

    public void hideLoadingView() {
        this.eFm.setVisibility(8);
        this.eFi.hideLoadingView(this.eFm);
    }

    public void Bf() {
        this.eFm.setVisibility(0);
        this.eFi.showNetRefreshView(this.eFm, this.eFi.getResources().getString(R.string.neterror));
    }

    public void Bg() {
        this.eFm.setVisibility(8);
        this.eFi.hideNetRefreshView(this.eFm);
    }

    public f aYW() {
        return this.eFk;
    }

    public void f(ChannelInfo channelInfo) {
        this.eFk.e(channelInfo);
    }
}
