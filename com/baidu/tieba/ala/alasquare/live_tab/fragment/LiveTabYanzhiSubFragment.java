package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.j0.q0.s0;
import d.a.j0.q0.t;
import d.a.j0.q0.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements s0 {
    public View n;
    public BdSwipeRefreshLayout o;
    public BdTypeRecyclerView p;
    public d.a.j0.t.d.c.a q;
    public g r;
    public PbListView s;
    public AlaLiveTabYanzhiModel t;
    public AlaLiveTabYanzhiModel.b u = new a();
    public f.g v = new b();
    public BdListView.p w = new c();
    public RecyclerView.OnScrollListener x = new d();

    /* loaded from: classes4.dex */
    public class a implements AlaLiveTabYanzhiModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.b
        public void a(boolean z, List<n> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.W0();
            } else {
                LiveTabYanzhiSubFragment.this.X0();
            }
            LiveTabYanzhiSubFragment.this.Z0();
            LiveTabYanzhiSubFragment.this.T0(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.b
        public void b(int i2, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.Z0();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                LiveTabYanzhiSubFragment.this.t.E();
            } else {
                LiveTabYanzhiSubFragment.this.Z0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.D()) {
                LiveTabYanzhiSubFragment.this.n();
            } else {
                LiveTabYanzhiSubFragment.this.t.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            Log.e("D444", "dy" + i3 + ", dx" + i2);
            if (i3 >= 4) {
                LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = LiveTabYanzhiSubFragment.this;
                if (liveTabYanzhiSubFragment.f14484i) {
                    return;
                }
                liveTabYanzhiSubFragment.F0();
            }
        }
    }

    public static LiveTabYanzhiSubFragment S0(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = new LiveTabYanzhiSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabYanzhiSubFragment.setArguments(bundle);
        return liveTabYanzhiSubFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void H0() {
        d.a.j0.t.d.c.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void Q0() {
        StatisticItem statisticItem = new StatisticItem("c13008");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.k);
        statisticItem.param("obj_locate", 2);
        statisticItem.param("obj_type", 15);
        statisticItem.eventStat();
    }

    public final void R0() {
        this.o = (BdSwipeRefreshLayout) this.n.findViewById(R.id.live_tab_refresh_layout);
        this.f14481f = (LinearLayout) this.n.findViewById(R.id.top_container);
        g gVar = new g(getPageContext());
        this.r = gVar;
        this.o.setProgressView(gVar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.n.findViewById(R.id.live_tab_list_view);
        this.p = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f14480e));
        this.p.setFadingEdgeLength(0);
        this.p.setOverScrollMode(2);
        this.q = new d.a.j0.t.d.c.a(getPageContext(), this.p, 102);
        PbListView pbListView = new PbListView(this.f14480e);
        this.s = pbListView;
        pbListView.a();
        this.s.o(R.color.transparent);
        this.s.r(l.g(this.f14480e, R.dimen.tbds182));
        this.s.v();
        this.s.E(R.dimen.tbfontsize33);
        this.s.C(SkinManager.getColor(R.color.CAM_X0107));
        this.s.y(R.color.CAM_X0110);
        this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.r.Z(getPageContext().getUniqueId());
        this.p.addOnScrollListener(this.x);
        U0(this.v);
        V0(this.w);
        if (G0()) {
            this.o.setEnabled(false);
            this.o.o();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void T0(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new t());
        }
        this.q.c(list);
    }

    public final void U0(f.g gVar) {
        g gVar2 = this.r;
        if (gVar2 != null) {
            gVar2.a(gVar);
        }
    }

    public final void V0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.p;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void W0() {
        PbListView pbListView = this.s;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.p.setNextPage(this.s);
            }
            this.s.r(l.g(this.f14480e, R.dimen.tbds182));
            this.s.A(this.f14480e.getResources().getString(R.string.loading));
            this.s.O();
        }
    }

    public final void X0() {
        PbListView pbListView = this.s;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.p.setNextPage(this.s);
            }
            this.s.r(l.g(this.f14480e, R.dimen.tbds182));
            this.s.A(this.f14480e.getResources().getString(R.string.list_no_more));
            this.s.f();
        }
    }

    public final void Y0() {
        if (G0()) {
            u uVar = new u();
            uVar.f58778a = 1120;
            uVar.f58779b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.o.setRefreshing(true);
    }

    public final void Z0() {
        if (G0()) {
            u uVar = new u();
            uVar.f58778a = 1120;
            uVar.f58779b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.o.setRefreshing(false);
    }

    @Override // d.a.j0.q0.s0
    public void k() {
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.t;
        if (alaLiveTabYanzhiModel != null) {
            alaLiveTabYanzhiModel.E();
        }
    }

    @Override // d.a.j0.q0.s0
    public void m() {
        if (j.z()) {
            AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.t;
            if (alaLiveTabYanzhiModel != null) {
                alaLiveTabYanzhiModel.E();
                return;
            }
            return;
        }
        Z0();
    }

    public final void n() {
        this.p.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        g gVar = this.r;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.s;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.s.d(i2);
        }
        d.a.j0.t.d.c.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14480e = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14483h = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.t == null) {
            this.t = new AlaLiveTabYanzhiModel(getPageContext(), this.u);
        }
        this.t.init();
        this.t.G(this.k, this.l);
        registerListener(this.m);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.n == null) {
            this.n = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            R0();
        }
        if (this.f14483h) {
            loadData();
        }
        return this.n;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BdTypeRecyclerView bdTypeRecyclerView = this.p;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.x);
            this.p.setOnSrollToBottomListener(null);
        }
        g gVar = this.r;
        if (gVar != null) {
            gVar.a(null);
            this.r.X();
        }
        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.t;
        if (alaLiveTabYanzhiModel != null) {
            alaLiveTabYanzhiModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Q0();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void p() {
        this.p.setSelection(0);
        Y0();
    }
}
