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
    private NoNetworkView dnF;
    private PbListView dnG;
    private ChannelHomeActivity eKe;
    private g eKf;
    private f eKg;
    private com.baidu.tieba.channel.a.c eKh = null;
    private FrameLayout eKi = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.eKe = channelHomeActivity;
        this.eKe.setIsAddSwipeBackLayout(true);
        this.eKe.setSwipeBackEnabled(true);
        this.eKe.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.eKe.setContentView(R.layout.channel_home_layout);
        this.mRootView = this.eKe.findViewById(R.id.channel_home_rootview);
        this.eKi = (FrameLayout) this.eKe.findViewById(R.id.channel_home_loading_view);
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.channel_home_no_network_view);
        this.eKf = new g(this.eKe.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(R.id.channel_home_navigation_bar), this.eKe);
        aJM();
    }

    private void aJM() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.channel_home_listview);
        this.eKg = new f(this.eKe.getPageContext().getPageActivity(), this.eKe);
        this.mListView.addHeaderView(this.eKg.aWR());
        this.eKh = new com.baidu.tieba.channel.a.c(this.eKe.getPageContext().getPageActivity(), this.mListView);
        this.eKh.a(this.eKe);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.eKe);
        this.dnG = new PbListView(this.eKe.getPageContext().getPageActivity());
        this.dnG.nZ();
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.mListView.setNextPage(this.dnG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.eKg != null) {
            int dimension = (int) this.eKe.getResources().getDimension(R.dimen.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.eKe.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int baP = this.eKg.baP() - (i4 + (-this.eKg.aWR().getTop()));
            if (this.eKf != null) {
                this.eKf.H(baP, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (baV() != null && baV().aWR() != null) {
            this.eKe.getLayoutMode().setNightMode(i == 1);
            this.eKe.getLayoutMode().onModeChanged(baV().aWR());
        }
        VX();
        this.eKg.onChangeSkinType(i);
        this.eKf.onChangeSkinType(i);
        this.dnG.iV(i);
        this.dnF.onChangeSkinType(this.eKe.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.baB() != null) {
            this.eKg.iN(dVar.isHost());
            this.eKg.d(dVar);
            this.eKh.setIsHost(dVar.isHost());
            h(dVar);
            this.eKf.a(dVar.isHost(), this.eKe);
            this.eKf.ao(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.baC() == null || dVar.baC().size() == 0) {
                aKk();
                this.mNoDataView = LayoutInflater.from(this.eKe.getPageContext().getPageActivity()).inflate(R.layout.channel_home_no_data, (ViewGroup) null);
                this.mListView.setNoData(this.mNoDataView);
            } else {
                this.mListView.setNoData((View) null);
                iO(true);
            }
            ArrayList arrayList = new ArrayList();
            if (dVar.baC() != null) {
                Iterator<E> it = dVar.baC().iterator();
                while (it.hasNext()) {
                    arrayList.add((m) it.next());
                }
            }
            this.mListView.setData(arrayList);
            if (!dVar.baD()) {
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
        this.eKf.ao(dVar);
        this.eKg.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.eKg.f(dVar);
    }

    public void iO(boolean z) {
        this.dnG.akE();
        if (z) {
            this.dnG.setText(this.eKe.getPageContext().getPageActivity().getResources().getString(R.string.list_no_more));
        } else {
            this.dnG.setText("");
        }
    }

    public void aKk() {
        this.dnG.iX(0);
    }

    public void baU() {
        this.dnG.akD();
    }

    public void showLoadingView() {
        this.eKe.showLoadingView(this.eKi);
        this.eKi.setVisibility(0);
    }

    public void hideLoadingView() {
        this.eKi.setVisibility(8);
        this.eKe.hideLoadingView(this.eKi);
    }

    public void BN() {
        this.eKi.setVisibility(0);
        this.eKe.showNetRefreshView(this.eKi, this.eKe.getResources().getString(R.string.neterror));
    }

    public void BO() {
        this.eKi.setVisibility(8);
        this.eKe.hideNetRefreshView(this.eKi);
    }

    public f baV() {
        return this.eKg;
    }

    public void f(ChannelInfo channelInfo) {
        this.eKg.e(channelInfo);
    }
}
