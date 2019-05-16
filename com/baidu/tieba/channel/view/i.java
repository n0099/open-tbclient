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
    private NoNetworkView dlW;
    private PbListView dlX;
    private ChannelHomeActivity eFh;
    private g eFi;
    private f eFj;
    private com.baidu.tieba.channel.a.c eFk = null;
    private FrameLayout eFl = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.eFh = channelHomeActivity;
        this.eFh.setIsAddSwipeBackLayout(true);
        this.eFh.setSwipeBackEnabled(true);
        this.eFh.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.eFh.setContentView(R.layout.channel_home_layout);
        this.mRootView = this.eFh.findViewById(R.id.channel_home_rootview);
        this.eFl = (FrameLayout) this.eFh.findViewById(R.id.channel_home_loading_view);
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.channel_home_no_network_view);
        this.eFi = new g(this.eFh.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(R.id.channel_home_navigation_bar), this.eFh);
        aIk();
    }

    private void aIk() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.channel_home_listview);
        this.eFj = new f(this.eFh.getPageContext().getPageActivity(), this.eFh);
        this.mListView.addHeaderView(this.eFj.aUT());
        this.eFk = new com.baidu.tieba.channel.a.c(this.eFh.getPageContext().getPageActivity(), this.mListView);
        this.eFk.a(this.eFh);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.eFh);
        this.dlX = new PbListView(this.eFh.getPageContext().getPageActivity());
        this.dlX.nG();
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
        this.mListView.setNextPage(this.dlX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.eFj != null) {
            int dimension = (int) this.eFh.getResources().getDimension(R.dimen.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.eFh.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int aYN = this.eFj.aYN() - (i4 + (-this.eFj.aUT().getTop()));
            if (this.eFi != null) {
                this.eFi.G(aYN, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (aYT() != null && aYT().aUT() != null) {
            this.eFh.getLayoutMode().setNightMode(i == 1);
            this.eFh.getLayoutMode().onModeChanged(aYT().aUT());
        }
        Ve();
        this.eFj.onChangeSkinType(i);
        this.eFi.onChangeSkinType(i);
        this.dlX.iP(i);
        this.dlW.onChangeSkinType(this.eFh.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aYz() != null) {
            this.eFj.iE(dVar.isHost());
            this.eFj.d(dVar);
            this.eFk.setIsHost(dVar.isHost());
            h(dVar);
            this.eFi.a(dVar.isHost(), this.eFh);
            this.eFi.ao(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aYA() == null || dVar.aYA().size() == 0) {
                aIG();
                this.mNoDataView = LayoutInflater.from(this.eFh.getPageContext().getPageActivity()).inflate(R.layout.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                iF(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aYA() != null) {
                Iterator<E> it = dVar.aYA().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.aYB()) {
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
        this.eFi.ao(dVar);
        this.eFj.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.eFj.f(dVar);
    }

    public void iF(boolean z) {
        this.dlX.ajz();
        if (z) {
            this.dlX.setText(this.eFh.getPageContext().getPageActivity().getResources().getString(R.string.list_no_more));
        } else {
            this.dlX.setText("");
        }
    }

    public void aIG() {
        this.dlX.iR(0);
    }

    public void aYS() {
        this.dlX.ajy();
    }

    public void showLoadingView() {
        this.eFh.showLoadingView(this.eFl);
        this.eFl.setVisibility(0);
    }

    public void hideLoadingView() {
        this.eFl.setVisibility(8);
        this.eFh.hideLoadingView(this.eFl);
    }

    public void Bf() {
        this.eFl.setVisibility(0);
        this.eFh.showNetRefreshView(this.eFl, this.eFh.getResources().getString(R.string.neterror));
    }

    public void Bg() {
        this.eFl.setVisibility(8);
        this.eFh.hideNetRefreshView(this.eFl);
    }

    public f aYT() {
        return this.eFj;
    }

    public void f(ChannelInfo channelInfo) {
        this.eFj.e(channelInfo);
    }
}
