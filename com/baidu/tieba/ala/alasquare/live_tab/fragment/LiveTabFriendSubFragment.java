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
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i0.d0.h;
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    public View n;
    public BdSwipeRefreshLayout o;
    public BdTypeRecyclerView p;
    public d.a.j0.t.d.c.a q;
    public g r;
    public PbListView s;
    public AlaLiveTabFriendModel t;
    public int u = 0;
    public AlaLiveTabFriendModel.b v = new a();
    public f.g w = new b();
    public BdListView.p x = new c();
    public RecyclerView.OnScrollListener y = new d();

    /* loaded from: classes4.dex */
    public class a implements AlaLiveTabFriendModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void a(boolean z, List<n> list) {
            LiveTabFriendSubFragment.this.n();
            LiveTabFriendSubFragment.this.U0();
            if (z) {
                LiveTabFriendSubFragment.this.a1();
            } else {
                LiveTabFriendSubFragment.this.d1();
            }
            LiveTabFriendSubFragment.this.f1();
            LiveTabFriendSubFragment.this.X0(list);
            if (ListUtils.isEmpty(list)) {
                LiveTabFriendSubFragment.this.J0();
            } else {
                LiveTabFriendSubFragment.this.E0();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void b(int i2, String str, boolean z) {
            LiveTabFriendSubFragment.this.f1();
            LiveTabFriendSubFragment.this.n();
            LiveTabFriendSubFragment.this.U0();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.t.B()) {
                    LiveTabFriendSubFragment.this.c1();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                LiveTabFriendSubFragment.this.t.D();
            } else {
                LiveTabFriendSubFragment.this.f1();
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
                LiveTabFriendSubFragment.this.T0();
            } else {
                LiveTabFriendSubFragment.this.t.C();
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
            if (i3 >= 4) {
                LiveTabFriendSubFragment liveTabFriendSubFragment = LiveTabFriendSubFragment.this;
                if (liveTabFriendSubFragment.f14484i) {
                    return;
                }
                liveTabFriendSubFragment.F0();
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
                LiveTabFriendSubFragment.this.loadData();
            }
        }
    }

    public static LiveTabFriendSubFragment W0(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabFriendSubFragment liveTabFriendSubFragment = new LiveTabFriendSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabFriendSubFragment.setArguments(bundle);
        return liveTabFriendSubFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void H0() {
        d.a.j0.t.d.c.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void T0() {
        this.p.setNextPage(null);
    }

    public final void U0() {
        this.f14481f.setVisibility(8);
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.f14481f);
            this.mRefreshView = null;
        }
    }

    public final void V0() {
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
        this.q = new d.a.j0.t.d.c.a(getPageContext(), this.p, 103);
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
        this.p.addOnScrollListener(this.y);
        Y0(this.w);
        Z0(this.x);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void X0(List<n> list) {
        this.q.c(list);
    }

    public final void Y0(f.g gVar) {
        g gVar2 = this.r;
        if (gVar2 != null) {
            gVar2.a(gVar);
        }
    }

    public final void Z0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.p;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void a1() {
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

    public final void b1() {
        this.f14481f.setVisibility(0);
        super.showLoadingView(this.f14481f, false, this.u);
    }

    public final void c1() {
        this.f14481f.setVisibility(0);
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new e());
        }
        this.mRefreshView.o();
        this.mRefreshView.l(null);
        this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.mRefreshView.k(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.f14481f, false);
    }

    public final void d1() {
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

    public final void e1() {
        this.o.setRefreshing(true);
    }

    public final void f1() {
        this.o.setRefreshing(false);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.t != null) {
            U0();
            b1();
            this.t.D();
        }
    }

    public final void n() {
        this.f14481f.setVisibility(8);
        super.hideLoadingView(this.f14481f);
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
            this.t = new AlaLiveTabFriendModel(getPageContext(), this.v);
            this.f14483h = true;
        }
        this.t.init();
        registerListener(this.m);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.n == null) {
            this.n = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            V0();
            if (viewGroup != null) {
                this.u = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
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
            bdTypeRecyclerView.removeOnScrollListener(this.y);
            this.p.setOnSrollToBottomListener(null);
        }
        g gVar = this.r;
        if (gVar != null) {
            gVar.a(null);
            this.r.X();
        }
        AlaLiveTabFriendModel alaLiveTabFriendModel = this.t;
        if (alaLiveTabFriendModel != null) {
            alaLiveTabFriendModel.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void p() {
        this.p.setSelection(0);
        e1();
    }
}
