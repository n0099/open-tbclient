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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    public View m;
    public BdSwipeRefreshLayout n;
    public BdTypeRecyclerView o;
    public d.b.i0.t.d.c.a p;
    public g q;
    public PbListView r;
    public AlaLiveTabFriendModel s;
    public int t = 0;
    public AlaLiveTabFriendModel.b u = new a();
    public f.g v = new b();
    public BdListView.p w = new c();
    public RecyclerView.OnScrollListener x = new d();

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
        public void b(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.f1();
            LiveTabFriendSubFragment.this.n();
            LiveTabFriendSubFragment.this.U0();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.s.B()) {
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

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                LiveTabFriendSubFragment.this.s.D();
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
            if (!l.C()) {
                LiveTabFriendSubFragment.this.T0();
            } else {
                LiveTabFriendSubFragment.this.s.C();
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
                LiveTabFriendSubFragment liveTabFriendSubFragment = LiveTabFriendSubFragment.this;
                if (liveTabFriendSubFragment.i) {
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
        d.b.i0.t.d.c.a aVar = this.p;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void T0() {
        this.o.setNextPage(null);
    }

    public final void U0() {
        this.f14745f.setVisibility(8);
        h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.f14745f);
            this.mRefreshView = null;
        }
    }

    public final void V0() {
        this.n = (BdSwipeRefreshLayout) this.m.findViewById(R.id.live_tab_refresh_layout);
        this.f14745f = (LinearLayout) this.m.findViewById(R.id.top_container);
        g gVar = new g(getPageContext());
        this.q = gVar;
        this.n.setProgressView(gVar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.m.findViewById(R.id.live_tab_list_view);
        this.o = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f14744e));
        this.o.setFadingEdgeLength(0);
        this.o.setOverScrollMode(2);
        this.p = new d.b.i0.t.d.c.a(getPageContext(), this.o, 103);
        PbListView pbListView = new PbListView(this.f14744e);
        this.r = pbListView;
        pbListView.a();
        this.r.o(R.color.transparent);
        this.r.r(l.g(this.f14744e, R.dimen.tbds182));
        this.r.v();
        this.r.E(R.dimen.tbfontsize33);
        this.r.C(SkinManager.getColor(R.color.CAM_X0107));
        this.r.y(R.color.CAM_X0110);
        this.r.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.q.Z(getPageContext().getUniqueId());
        this.o.addOnScrollListener(this.x);
        Y0(this.v);
        Z0(this.w);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void X0(List<n> list) {
        this.p.c(list);
    }

    public final void Y0(f.g gVar) {
        g gVar2 = this.q;
        if (gVar2 != null) {
            gVar2.b(gVar);
        }
    }

    public final void Z0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.o;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void a1() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.o.setNextPage(this.r);
            }
            this.r.r(l.g(this.f14744e, R.dimen.tbds182));
            this.r.A(this.f14744e.getResources().getString(R.string.loading));
            this.r.O();
        }
    }

    public final void b1() {
        this.f14745f.setVisibility(0);
        super.showLoadingView(this.f14745f, false, this.t);
    }

    public final void c1() {
        this.f14745f.setVisibility(0);
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new e());
        }
        this.mRefreshView.o();
        this.mRefreshView.l(null);
        this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.i(R.drawable.new_pic_emotion_08);
        this.mRefreshView.k(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.f14745f, false);
    }

    public final void d1() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.o.setNextPage(this.r);
            }
            this.r.r(l.g(this.f14744e, R.dimen.tbds182));
            this.r.A(this.f14744e.getResources().getString(R.string.list_no_more));
            this.r.f();
        }
    }

    public final void e1() {
        this.n.setRefreshing(true);
    }

    public final void f1() {
        this.n.setRefreshing(false);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.s != null) {
            U0();
            b1();
            this.s.D();
        }
    }

    public final void n() {
        this.f14745f.setVisibility(8);
        super.hideLoadingView(this.f14745f);
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
        this.f14744e = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14747h = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.s == null) {
            this.s = new AlaLiveTabFriendModel(getPageContext(), this.u);
            this.f14747h = true;
        }
        this.s.init();
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.m == null) {
            this.m = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            V0();
            if (viewGroup != null) {
                this.t = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.f14747h) {
            loadData();
        }
        return this.m;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BdTypeRecyclerView bdTypeRecyclerView = this.o;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.x);
            this.o.setOnSrollToBottomListener(null);
        }
        g gVar = this.q;
        if (gVar != null) {
            gVar.b(null);
            this.q.X();
        }
        AlaLiveTabFriendModel alaLiveTabFriendModel = this.s;
        if (alaLiveTabFriendModel != null) {
            alaLiveTabFriendModel.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void w() {
        this.o.setSelection(0);
        e1();
    }
}
