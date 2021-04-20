package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    public View m;
    public BdSwipeRefreshLayout n;
    public BdTypeRecyclerView o;
    public d.b.i0.t.d.c.a p;
    public g q;
    public PbListView r;
    public AlaLiveTabRecomModel s;
    public AlaLiveTabRecomModel.b t = new a();
    public f.g u = new b();
    public BdListView.p v = new c();
    public RecyclerView.OnScrollListener w = new d();

    /* loaded from: classes4.dex */
    public class a implements AlaLiveTabRecomModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void a(boolean z, List<n> list) {
            if (z) {
                LiveTabRecomSubFragment.this.V0();
            } else {
                LiveTabRecomSubFragment.this.W0();
            }
            LiveTabRecomSubFragment.this.Y0();
            LiveTabRecomSubFragment.this.S0(list);
            if (ListUtils.isEmpty(list)) {
                LiveTabRecomSubFragment.this.J0();
            } else {
                LiveTabRecomSubFragment.this.E0();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void b(int i, String str, boolean z) {
            LiveTabRecomSubFragment.this.Y0();
            if (z) {
                LiveTabRecomSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                LiveTabRecomSubFragment.this.s.E();
            } else {
                LiveTabRecomSubFragment.this.Y0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.C()) {
                LiveTabRecomSubFragment.this.n();
            } else {
                LiveTabRecomSubFragment.this.s.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4) {
                LiveTabRecomSubFragment liveTabRecomSubFragment = LiveTabRecomSubFragment.this;
                if (liveTabRecomSubFragment.i) {
                    return;
                }
                liveTabRecomSubFragment.F0();
            }
        }
    }

    public static LiveTabRecomSubFragment R0(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabRecomSubFragment liveTabRecomSubFragment = new LiveTabRecomSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabRecomSubFragment.setArguments(bundle);
        return liveTabRecomSubFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void H0() {
        d.b.i0.t.d.c.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void Q0() {
        this.n = (BdSwipeRefreshLayout) this.m.findViewById(R.id.live_tab_refresh_layout);
        this.f14409f = (LinearLayout) this.m.findViewById(R.id.top_container);
        g gVar = new g(getPageContext());
        this.q = gVar;
        this.n.setProgressView(gVar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.m.findViewById(R.id.live_tab_list_view);
        this.o = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f14408e));
        this.o.setFadingEdgeLength(0);
        this.o.setOverScrollMode(2);
        this.p = new d.b.i0.t.d.c.a(getPageContext(), this.o, 101);
        PbListView pbListView = new PbListView(this.f14408e);
        this.r = pbListView;
        pbListView.a();
        this.r.o(R.color.transparent);
        this.r.r(l.g(this.f14408e, R.dimen.tbds182));
        this.r.v();
        this.r.E(R.dimen.tbfontsize33);
        this.r.C(SkinManager.getColor(R.color.CAM_X0107));
        this.r.y(R.color.CAM_X0110);
        this.r.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.q.Z(getPageContext().getUniqueId());
        this.o.addOnScrollListener(this.w);
        T0(this.u);
        U0(this.v);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void S0(List<n> list) {
        this.p.c(list);
    }

    public final void T0(f.g gVar) {
        g gVar2 = this.q;
        if (gVar2 != null) {
            gVar2.b(gVar);
        }
    }

    public final void U0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.o;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void V0() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.o.setNextPage(this.r);
            }
            this.r.r(l.g(this.f14408e, R.dimen.tbds182));
            this.r.A(this.f14408e.getResources().getString(R.string.loading));
            this.r.O();
        }
    }

    public final void W0() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.o.setNextPage(this.r);
            }
            this.r.r(l.g(this.f14408e, R.dimen.tbds182));
            this.r.A(this.f14408e.getResources().getString(R.string.list_no_more));
            this.r.f();
        }
    }

    public final void X0() {
        this.n.setRefreshing(true);
    }

    public final void Y0() {
        this.n.setRefreshing(false);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabRecomModel alaLiveTabRecomModel = this.s;
        if (alaLiveTabRecomModel != null) {
            alaLiveTabRecomModel.E();
        }
    }

    public final void n() {
        this.o.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        g gVar = this.q;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.r;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.r.d(i);
        }
        d.b.i0.t.d.c.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14408e = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14411h = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.s == null) {
            this.s = new AlaLiveTabRecomModel(getPageContext(), this.t);
        }
        this.s.init();
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.m == null) {
            this.m = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            Q0();
        }
        if (this.f14411h) {
            loadData();
        }
        return this.m;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BdTypeRecyclerView bdTypeRecyclerView = this.o;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.w);
            this.o.setOnSrollToBottomListener(null);
        }
        g gVar = this.q;
        if (gVar != null) {
            gVar.b(null);
            this.q.X();
        }
        AlaLiveTabRecomModel alaLiveTabRecomModel = this.s;
        if (alaLiveTabRecomModel != null) {
            alaLiveTabRecomModel.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void w() {
        this.o.setSelection(0);
        X0();
    }
}
