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
    private NoNetworkView dpy;
    private PbListView dpz;
    private ChannelHomeActivity eLU;
    private g eLV;
    private f eLW;
    private com.baidu.tieba.channel.a.c eLX = null;
    private FrameLayout eLY = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.eLU = channelHomeActivity;
        this.eLU.setIsAddSwipeBackLayout(true);
        this.eLU.setSwipeBackEnabled(true);
        this.eLU.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.eLU.setContentView(R.layout.channel_home_layout);
        this.mRootView = this.eLU.findViewById(R.id.channel_home_rootview);
        this.eLY = (FrameLayout) this.eLU.findViewById(R.id.channel_home_loading_view);
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.channel_home_no_network_view);
        this.eLV = new g(this.eLU.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(R.id.channel_home_navigation_bar), this.eLU);
        aKs();
    }

    private void aKs() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.channel_home_listview);
        this.eLW = new f(this.eLU.getPageContext().getPageActivity(), this.eLU);
        this.mListView.addHeaderView(this.eLW.aXx());
        this.eLX = new com.baidu.tieba.channel.a.c(this.eLU.getPageContext().getPageActivity(), this.mListView);
        this.eLX.a(this.eLU);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.eLU);
        this.dpz = new PbListView(this.eLU.getPageContext().getPageActivity());
        this.dpz.nZ();
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
        this.mListView.setNextPage(this.dpz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.eLW != null) {
            int dimension = (int) this.eLU.getResources().getDimension(R.dimen.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.eLU.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int bbv = this.eLW.bbv() - (i4 + (-this.eLW.aXx().getTop()));
            if (this.eLV != null) {
                this.eLV.I(bbv, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (bbB() != null && bbB().aXx() != null) {
            this.eLU.getLayoutMode().setNightMode(i == 1);
            this.eLU.getLayoutMode().onModeChanged(bbB().aXx());
        }
        Wb();
        this.eLW.onChangeSkinType(i);
        this.eLV.onChangeSkinType(i);
        this.dpz.iY(i);
        this.dpy.onChangeSkinType(this.eLU.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbh() != null) {
            this.eLW.iQ(dVar.isHost());
            this.eLW.d(dVar);
            this.eLX.setIsHost(dVar.isHost());
            h(dVar);
            this.eLV.a(dVar.isHost(), this.eLU);
            this.eLV.ao(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.bbi() == null || dVar.bbi().size() == 0) {
                aKQ();
                this.mNoDataView = LayoutInflater.from(this.eLU.getPageContext().getPageActivity()).inflate(R.layout.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                iR(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.bbi() != null) {
                Iterator<E> it = dVar.bbi().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.bbj()) {
                iR(true);
            }
        }
    }

    public void Wb() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eLV.ao(dVar);
        this.eLW.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.eLW.f(dVar);
    }

    public void iR(boolean z) {
        this.dpz.akS();
        if (z) {
            this.dpz.setText(this.eLU.getPageContext().getPageActivity().getResources().getString(R.string.list_no_more));
        } else {
            this.dpz.setText("");
        }
    }

    public void aKQ() {
        this.dpz.ja(0);
    }

    public void bbA() {
        this.dpz.akR();
    }

    public void showLoadingView() {
        this.eLU.showLoadingView(this.eLY);
        this.eLY.setVisibility(0);
    }

    public void hideLoadingView() {
        this.eLY.setVisibility(8);
        this.eLU.hideLoadingView(this.eLY);
    }

    public void BR() {
        this.eLY.setVisibility(0);
        this.eLU.showNetRefreshView(this.eLY, this.eLU.getResources().getString(R.string.neterror));
    }

    public void BS() {
        this.eLY.setVisibility(8);
        this.eLU.hideNetRefreshView(this.eLY);
    }

    public f bbB() {
        return this.eLW;
    }

    public void f(ChannelInfo channelInfo) {
        this.eLW.e(channelInfo);
    }
}
