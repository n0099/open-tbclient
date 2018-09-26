package com.baidu.tieba.channel.view;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class i {
    private NoNetworkView bBq;
    private PbListView bBr;
    private ChannelHomeActivity cMe;
    private g cMf;
    private f cMg;
    private com.baidu.tieba.channel.a.c cMh = null;
    private FrameLayout cMi = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.cMe = channelHomeActivity;
        this.cMe.setIsAddSwipeBackLayout(true);
        this.cMe.setSwipeBackEnabled(true);
        this.cMe.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.cMe.setContentView(e.h.channel_home_layout);
        this.mRootView = this.cMe.findViewById(e.g.channel_home_rootview);
        this.cMi = (FrameLayout) this.cMe.findViewById(e.g.channel_home_loading_view);
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.channel_home_no_network_view);
        this.cMf = new g(this.cMe.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(e.g.channel_home_navigation_bar), this.cMe);
        Vz();
    }

    private void Vz() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.channel_home_listview);
        this.cMg = new f(this.cMe.getPageContext().getPageActivity(), this.cMe);
        this.mListView.addHeaderView(this.cMg.aiP());
        this.cMh = new com.baidu.tieba.channel.a.c(this.cMe.getPageContext().getPageActivity(), this.mListView);
        this.cMh.a(this.cMe);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.cMe);
        this.bBr = new PbListView(this.cMe.getPageContext().getPageActivity());
        this.bBr.ov();
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
        this.mListView.setNextPage(this.bBr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.cMg != null) {
            int dimension = (int) this.cMe.getResources().getDimension(e.C0141e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.cMe.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int alL = this.cMg.alL() - (i4 + (-this.cMg.aiP().getTop()));
            if (this.cMf != null) {
                this.cMf.C(alL, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (alU() != null && alU().aiP() != null) {
            this.cMe.getLayoutMode().setNightMode(i == 1);
            this.cMe.getLayoutMode().onModeChanged(alU().aiP());
        }
        alQ();
        this.cMg.onChangeSkinType(i);
        this.cMf.onChangeSkinType(i);
        this.bBr.dM(i);
        this.bBq.onChangeSkinType(this.cMe.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.alx() != null) {
            this.cMg.eY(dVar.isHost());
            this.cMg.d(dVar);
            this.cMh.setIsHost(dVar.isHost());
            h(dVar);
            this.cMf.a(dVar.isHost(), this.cMe);
            this.cMf.W(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.aly() == null || dVar.aly().size() == 0) {
                Wd();
                this.mNoDataView = LayoutInflater.from(this.cMe.getPageContext().getPageActivity()).inflate(e.h.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                eZ(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.aly() != null) {
                Iterator<E> it = dVar.aly().iterator();
                while (it.hasNext()) {
                    arrayList.add((com.baidu.adp.widget.ListView.h) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.alz()) {
                eZ(true);
            }
        }
    }

    public void alQ() {
        if (this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cMf.W(dVar);
        this.cMg.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.cMg.f(dVar);
    }

    public void eZ(boolean z) {
        this.bBr.BJ();
        if (z) {
            this.bBr.setText(this.cMe.getPageContext().getPageActivity().getResources().getString(e.j.list_no_more));
        } else {
            this.bBr.setText("");
        }
    }

    public void Wd() {
        this.bBr.dO(0);
    }

    public void alR() {
        this.bBr.BI();
    }

    public void showLoadingView() {
        this.cMe.showLoadingView(this.cMi);
        this.cMi.setVisibility(0);
    }

    public void hideLoadingView() {
        this.cMi.setVisibility(8);
        this.cMe.hideLoadingView(this.cMi);
    }

    public void alS() {
        this.cMi.setVisibility(0);
        this.cMe.showNetRefreshView(this.cMi, this.cMe.getResources().getString(e.j.neterror));
    }

    public void alT() {
        this.cMi.setVisibility(8);
        this.cMe.hideNetRefreshView(this.cMi);
    }

    public f alU() {
        return this.cMg;
    }

    public void f(ChannelInfo channelInfo) {
        this.cMg.e(channelInfo);
    }
}
