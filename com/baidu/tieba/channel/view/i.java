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
    private NoNetworkView cba;
    private PbListView cbb;
    private ChannelHomeActivity der;
    private g det;
    private f deu;
    private com.baidu.tieba.channel.a.c dev = null;
    private FrameLayout dew = null;
    private BdTypeListView mListView;
    private View mNoDataView;
    private View mRootView;

    public i(ChannelHomeActivity channelHomeActivity) {
        this.der = channelHomeActivity;
        this.der.setIsAddSwipeBackLayout(true);
        this.der.setSwipeBackEnabled(true);
        this.der.setUseStyleImmersiveSticky(true);
        initViews();
    }

    public void initViews() {
        this.der.setContentView(d.h.channel_home_layout);
        this.mRootView = this.der.findViewById(d.g.channel_home_rootview);
        this.dew = (FrameLayout) this.der.findViewById(d.g.channel_home_loading_view);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.channel_home_no_network_view);
        this.det = new g(this.der.getPageContext().getPageActivity(), (NavigationBar) this.mRootView.findViewById(d.g.channel_home_navigation_bar), this.der);
        Xm();
    }

    private void Xm() {
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.channel_home_listview);
        this.deu = new f(this.der.getPageContext().getPageActivity(), this.der);
        this.mListView.addHeaderView(this.deu.aix());
        this.dev = new com.baidu.tieba.channel.a.c(this.der.getPageContext().getPageActivity(), this.mListView);
        this.dev.a(this.der);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.channel.view.i.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                i.this.a(absListView, i, i2, i3);
            }
        });
        this.mListView.setOnSrollToBottomListener(this.der);
        this.cbb = new PbListView(this.der.getPageContext().getPageActivity());
        this.cbb.st();
        this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
        this.mListView.setNextPage(this.cbb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11 && this.deu != null) {
            int dimension = (int) this.der.getResources().getDimension(d.e.ds98);
            int i4 = 0;
            if (UtilHelper.useNavigationBarStyleImmersiveSticky(this.der.getPageContext().getPageActivity())) {
                i4 = UtilHelper.getStatusBarHeight();
            }
            int amy = this.deu.amy() - (i4 + (-this.deu.aix().getTop()));
            if (this.det != null) {
                this.det.J(amy, dimension, i);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (amH() != null && amH().aix() != null) {
            this.der.getLayoutMode().aQ(i == 1);
            this.der.getLayoutMode().aM(amH().aix());
        }
        amD();
        this.deu.onChangeSkinType(i);
        this.det.onChangeSkinType(i);
        this.cbb.gx(i);
        this.cba.onChangeSkinType(this.der.getPageContext(), i);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
    }

    public void g(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.amj() != null) {
            this.deu.eW(dVar.isHost());
            this.deu.d(dVar);
            this.dev.setIsHost(dVar.isHost());
            h(dVar);
            this.det.a(dVar.isHost(), this.der);
            this.det.aT(dVar);
        }
    }

    public void h(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null) {
            if (dVar.amk() == null || dVar.amk().size() == 0) {
                XQ();
                this.mNoDataView = LayoutInflater.from(this.der.getPageContext().getPageActivity()).inflate(d.h.channel_home_no_data, (ViewGroup) null);
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
        this.det.aT(dVar);
        this.deu.e(dVar);
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        this.deu.f(dVar);
    }

    public void eX(boolean z) {
        this.cbb.Eh();
        if (z) {
            this.cbb.setText(this.der.getPageContext().getPageActivity().getResources().getString(d.j.list_no_more));
        } else {
            this.cbb.setText("");
        }
    }

    public void XQ() {
        this.cbb.gz(0);
    }

    public void amE() {
        this.cbb.Eg();
    }

    public void VU() {
        this.der.showLoadingView(this.dew);
        this.dew.setVisibility(0);
    }

    public void VV() {
        this.dew.setVisibility(8);
        this.der.hideLoadingView(this.dew);
    }

    public void amF() {
        this.dew.setVisibility(0);
        this.der.showNetRefreshView(this.dew, this.der.getResources().getString(d.j.neterror));
    }

    public void amG() {
        this.dew.setVisibility(8);
        this.der.hideNetRefreshView(this.dew);
    }

    public f amH() {
        return this.deu;
    }

    public void f(ChannelInfo channelInfo) {
        this.deu.e(channelInfo);
    }
}
