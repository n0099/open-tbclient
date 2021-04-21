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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import d.b.j0.q0.s0;
import d.b.j0.q0.t;
import d.b.j0.q0.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements s0 {
    public View m;
    public BdSwipeRefreshLayout n;
    public BdTypeRecyclerView o;
    public d.b.j0.t.d.c.a p;
    public g q;
    public PbListView r;
    public AlaLiveTabYanzhiModel s;
    public AlaLiveTabYanzhiModel.b t = new a();
    public f.g u = new b();
    public BdListView.p v = new c();
    public RecyclerView.OnScrollListener w = new d();

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
        public void b(int i, String str, boolean z) {
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

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                LiveTabYanzhiSubFragment.this.s.E();
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
            if (!l.C()) {
                LiveTabYanzhiSubFragment.this.n();
            } else {
                LiveTabYanzhiSubFragment.this.s.D();
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
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4) {
                LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = LiveTabYanzhiSubFragment.this;
                if (liveTabYanzhiSubFragment.i) {
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
        d.b.j0.t.d.c.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void Q0() {
        StatisticItem statisticItem = new StatisticItem("c13008");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.j);
        statisticItem.param("obj_locate", 2);
        statisticItem.param("obj_type", 15);
        statisticItem.eventStat();
    }

    public final void R0() {
        this.n = (BdSwipeRefreshLayout) this.m.findViewById(R.id.live_tab_refresh_layout);
        this.f14417f = (LinearLayout) this.m.findViewById(R.id.top_container);
        g gVar = new g(getPageContext());
        this.q = gVar;
        this.n.setProgressView(gVar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.m.findViewById(R.id.live_tab_list_view);
        this.o = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f14416e));
        this.o.setFadingEdgeLength(0);
        this.o.setOverScrollMode(2);
        this.p = new d.b.j0.t.d.c.a(getPageContext(), this.o, 102);
        PbListView pbListView = new PbListView(this.f14416e);
        this.r = pbListView;
        pbListView.a();
        this.r.o(R.color.transparent);
        this.r.r(l.g(this.f14416e, R.dimen.tbds182));
        this.r.v();
        this.r.E(R.dimen.tbfontsize33);
        this.r.C(SkinManager.getColor(R.color.CAM_X0107));
        this.r.y(R.color.CAM_X0110);
        this.r.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.q.Z(getPageContext().getUniqueId());
        this.o.addOnScrollListener(this.w);
        U0(this.u);
        V0(this.v);
        if (G0()) {
            this.n.setEnabled(false);
            this.n.o();
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
        this.p.c(list);
    }

    public final void U0(f.g gVar) {
        g gVar2 = this.q;
        if (gVar2 != null) {
            gVar2.b(gVar);
        }
    }

    public final void V0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.o;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void W0() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.o.setNextPage(this.r);
            }
            this.r.r(l.g(this.f14416e, R.dimen.tbds182));
            this.r.A(this.f14416e.getResources().getString(R.string.loading));
            this.r.O();
        }
    }

    public final void X0() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.o.setNextPage(this.r);
            }
            this.r.r(l.g(this.f14416e, R.dimen.tbds182));
            this.r.A(this.f14416e.getResources().getString(R.string.list_no_more));
            this.r.f();
        }
    }

    public final void Y0() {
        if (G0()) {
            u uVar = new u();
            uVar.f60671a = 1120;
            uVar.f60672b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.n.setRefreshing(true);
    }

    public final void Z0() {
        if (G0()) {
            u uVar = new u();
            uVar.f60671a = 1120;
            uVar.f60672b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.n.setRefreshing(false);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.s;
        if (alaLiveTabYanzhiModel != null) {
            alaLiveTabYanzhiModel.E();
        }
    }

    @Override // d.b.j0.q0.s0
    public void m() {
        if (j.z()) {
            AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.s;
            if (alaLiveTabYanzhiModel != null) {
                alaLiveTabYanzhiModel.E();
                return;
            }
            return;
        }
        Z0();
    }

    public final void n() {
        this.o.setNextPage(null);
    }

    @Override // d.b.j0.q0.s0
    public void o() {
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
        d.b.j0.t.d.c.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14416e = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14419h = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.s == null) {
            this.s = new AlaLiveTabYanzhiModel(getPageContext(), this.t);
        }
        this.s.init();
        this.s.G(this.j, this.k);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.m == null) {
            this.m = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            R0();
        }
        if (this.f14419h) {
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
        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.s;
        if (alaLiveTabYanzhiModel != null) {
            alaLiveTabYanzhiModel.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Q0();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void w() {
        this.o.setSelection(0);
        Y0();
    }
}
