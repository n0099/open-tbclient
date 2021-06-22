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
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.d0.h;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabYYSubFragment extends LiveTabBaseSubFragment {
    public View n;
    public BdSwipeRefreshLayout o;
    public BdTypeRecyclerView p;
    public d.a.o0.v.d.c.a q;
    public g r;
    public PbListView s;
    public AlaLiveYYSubTabModel t;
    public int u = 0;
    public int v = 4;
    public AlaLiveYYSubTabModel.b w = new a();
    public f.g x = new b();
    public BdListView.p y = new c();
    public RecyclerView.OnScrollListener z = new d();

    /* loaded from: classes4.dex */
    public class a implements AlaLiveYYSubTabModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.b
        public void a(boolean z, List<n> list) {
            LiveTabYYSubFragment.this.o();
            LiveTabYYSubFragment.this.X0();
            if (z) {
                LiveTabYYSubFragment.this.d1();
            } else {
                LiveTabYYSubFragment.this.g1();
            }
            LiveTabYYSubFragment.this.i1();
            LiveTabYYSubFragment.this.a1(list);
            if (ListUtils.isEmpty(list)) {
                LiveTabYYSubFragment.this.L0();
            } else {
                LiveTabYYSubFragment.this.G0();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.b
        public void b(int i2, String str, boolean z) {
            LiveTabYYSubFragment.this.i1();
            LiveTabYYSubFragment.this.o();
            LiveTabYYSubFragment.this.X0();
            if (!z) {
                if (!LiveTabYYSubFragment.this.t.b()) {
                    LiveTabYYSubFragment.this.f1();
                    return;
                } else {
                    LiveTabYYSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabYYSubFragment.this.showToast(R.string.data_load_error);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                LiveTabYYSubFragment.this.t.refresh();
            } else {
                LiveTabYYSubFragment.this.i1();
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
                LiveTabYYSubFragment.this.W0();
            } else {
                LiveTabYYSubFragment.this.t.loadMore();
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
            if (i3 >= LiveTabYYSubFragment.this.v) {
                LiveTabYYSubFragment liveTabYYSubFragment = LiveTabYYSubFragment.this;
                if (liveTabYYSubFragment.f13849i) {
                    return;
                }
                liveTabYYSubFragment.H0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                LiveTabYYSubFragment.this.loadData();
            }
        }
    }

    public static LiveTabYYSubFragment Z0(boolean z, int i2) {
        Bundle bundle = new Bundle();
        LiveTabYYSubFragment liveTabYYSubFragment = new LiveTabYYSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        bundle.putInt("arg_tab_id", i2);
        liveTabYYSubFragment.setArguments(bundle);
        return liveTabYYSubFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void J0() {
        d.a.o0.v.d.c.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void W0() {
        this.p.setNextPage(null);
    }

    public final void X0() {
        this.f13846f.setVisibility(8);
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.f13846f);
            this.mRefreshView = null;
        }
    }

    public final void Y0() {
        this.o = (BdSwipeRefreshLayout) this.n.findViewById(R.id.live_tab_refresh_layout);
        this.f13846f = (LinearLayout) this.n.findViewById(R.id.top_container);
        g gVar = new g(getPageContext());
        this.r = gVar;
        this.o.setProgressView(gVar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.n.findViewById(R.id.live_tab_list_view);
        this.p = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f13845e));
        this.p.setFadingEdgeLength(0);
        this.p.setOverScrollMode(2);
        this.q = new d.a.o0.v.d.c.a(getPageContext(), this.p, this.j);
        PbListView pbListView = new PbListView(this.f13845e);
        this.s = pbListView;
        pbListView.a();
        this.s.o(R.color.transparent);
        this.s.r(l.g(this.f13845e, R.dimen.tbds182));
        this.s.v();
        this.s.E(R.dimen.tbfontsize33);
        this.s.C(SkinManager.getColor(R.color.CAM_X0107));
        this.s.y(R.color.CAM_X0110);
        this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.r.Z(getPageContext().getUniqueId());
        this.p.addOnScrollListener(this.z);
        b1(this.x);
        c1(this.y);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a1(List<n> list) {
        this.q.c(list);
    }

    public final void b1(f.g gVar) {
        g gVar2 = this.r;
        if (gVar2 != null) {
            gVar2.a(gVar);
        }
    }

    public final void c1(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.p;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void d1() {
        PbListView pbListView = this.s;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.p.setNextPage(this.s);
            }
            this.s.r(l.g(this.f13845e, R.dimen.tbds182));
            this.s.A(this.f13845e.getResources().getString(R.string.loading));
            this.s.O();
        }
    }

    public final void e1() {
        this.f13846f.setVisibility(0);
        super.showLoadingView(this.f13846f, false, this.u);
    }

    public final void f1() {
        this.f13846f.setVisibility(0);
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new e());
        }
        this.mRefreshView.o();
        this.mRefreshView.l(null);
        this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.mRefreshView.k(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.f13846f, false);
    }

    public final void g1() {
        PbListView pbListView = this.s;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.p.setNextPage(this.s);
            }
            this.s.r(l.g(this.f13845e, R.dimen.tbds182));
            this.s.A(this.f13845e.getResources().getString(R.string.list_no_more));
            this.s.f();
        }
    }

    public final void h1() {
        this.o.setRefreshing(true);
    }

    public final void i1() {
        this.o.setRefreshing(false);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.t != null) {
            X0();
            e1();
            this.t.refresh();
        }
    }

    public final void o() {
        this.f13846f.setVisibility(8);
        super.hideLoadingView(this.f13846f);
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
        d.a.o0.v.d.c.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13845e = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13848h = arguments.getBoolean("arg_after_lazy_loaded", false);
            this.j = arguments.getInt("arg_tab_id", 0);
        }
        if (this.t == null) {
            this.t = new AlaLiveYYSubTabModel(getPageContext(), this.w, this.j);
        }
        this.t.init();
        this.t.I(this.k, this.l);
        registerListener(this.m);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.n == null) {
            this.n = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            Y0();
            if (viewGroup != null) {
                this.u = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.f13848h) {
            loadData();
        }
        return this.n;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BdTypeRecyclerView bdTypeRecyclerView = this.p;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.z);
            this.p.setOnSrollToBottomListener(null);
        }
        g gVar = this.r;
        if (gVar != null) {
            gVar.a(null);
            this.r.X();
        }
        AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.t;
        if (alaLiveYYSubTabModel != null) {
            alaLiveYYSubTabModel.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void r() {
        this.p.setSelection(0);
        h1();
    }
}
