package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.google.android.material.tabs.TabLayout;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.z0.e.a.d.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HotTopicTabView extends FrameLayout implements f.g {

    /* renamed from: e  reason: collision with root package name */
    public int f17170e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f17171f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.z0.e.a.b f17172g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f17173h;
    public BdTypeRecyclerView i;
    public h j;
    public g k;
    public d.b.h0.d0.g l;
    public d.b.h0.d0.h m;
    public ScrollFragmentTabHost n;
    public int o;
    public PbListView p;
    public HotTopicHeaderView q;
    public TabLayout.OnTabSelectedListener r;
    public d.b.h0.m.f s;
    public boolean t;
    public RecyclerView.OnScrollListener u;
    public ScrollFragmentTabHost.q v;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (HotTopicTabView.this.o == i || HotTopicTabView.this.n == null) {
                return;
            }
            HotTopicTabView.this.o = i;
            if (HotTopicTabView.this.o == 1) {
                HotTopicTabView.this.n.Q();
            } else if (HotTopicTabView.this.s(recyclerView)) {
                HotTopicTabView.this.n.u();
            } else {
                HotTopicTabView.this.n.Q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ScrollFragmentTabHost.q {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.q
        public void c() {
            if (HotTopicTabView.this.n != null) {
                HotTopicTabView.this.o = -1;
                HotTopicTabView hotTopicTabView = HotTopicTabView.this;
                if (hotTopicTabView.s(hotTopicTabView.i)) {
                    HotTopicTabView.this.n.u();
                } else {
                    HotTopicTabView.this.n.Q();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || HotTopicTabView.this.f17172g == null) {
                return;
            }
            HotTopicTabView.this.v(false);
            HotTopicTabView.this.f17172g.loadData();
        }
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f17170e = 3;
        this.o = -1;
        this.u = new a();
        this.v = new b();
        this.f17171f = tbPageContext;
        l(tbPageContext.getPageActivity());
        m();
        r();
    }

    public void g() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.n;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.v);
        }
        z();
        h();
        i();
        this.t = true;
    }

    public void h() {
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.dettachView(this);
            this.l = null;
        }
    }

    public void i() {
        d.b.h0.d0.h hVar = this.m;
        if (hVar != null) {
            hVar.dettachView(this);
            this.m = null;
        }
    }

    public void k() {
        this.i.setNextPage(null);
    }

    public final void l(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.f17173h = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        g gVar = new g(this.f17171f);
        this.k = gVar;
        this.f17173h.setProgressView(gVar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.i = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.i.setFadingEdgeLength(0);
        this.i.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.j = new h(this.f17171f, this.i);
        PbListView pbListView = new PbListView(this.f17171f.getPageActivity());
        this.p = pbListView;
        pbListView.a();
        this.p.o(R.color.CAM_X0205);
        this.p.y(R.color.CAM_X0111);
    }

    public final void m() {
        this.i.addOnScrollListener(this.u);
        this.k.b(this);
    }

    public boolean n() {
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean o() {
        d.b.h0.d0.h hVar = this.m;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        g();
        super.onDetachedFromWindow();
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f17172g.loadData();
    }

    public boolean q() {
        HotTopicHeaderView hotTopicHeaderView = this.q;
        return (hotTopicHeaderView == null || hotTopicHeaderView.getParent() == null) ? false : true;
    }

    public void r() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17170e) {
            return;
        }
        this.f17170e = skinType;
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(skinType);
        }
        d.b.h0.d0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        d.b.h0.d0.h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        h hVar2 = this.j;
        if (hVar2 != null) {
            hVar2.c();
        }
        PbListView pbListView = this.p;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.p.o(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.q;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.c(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.i;
        if (bdTypeRecyclerView != null) {
            d.b.h0.r.u.c.a(bdTypeRecyclerView).c(R.color.CAM_X0202);
        }
    }

    public final boolean s(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return true;
        }
        return !recyclerView.canScrollVertically(-1);
    }

    public void setData(@NonNull d.b.i0.z0.e.a.f.a aVar) {
        u(aVar);
        setListData(aVar.getDataList());
    }

    public void setListData(@NonNull List<n> list) {
        this.j.d(list);
    }

    public void setOnItemCoverListener(d.b.h0.m.f fVar) {
        this.s = fVar;
        h hVar = this.j;
        if (hVar != null) {
            hVar.e(fVar);
        }
        HotTopicHeaderView hotTopicHeaderView = this.q;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.setOnItemCoverListener(fVar);
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.r = onTabSelectedListener;
    }

    public void setPresenter(d.b.i0.z0.e.a.b bVar) {
        this.f17172g = bVar;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.n = scrollFragmentTabHost;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.v);
            this.n.s(this.v);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        h hVar = this.j;
        if (hVar != null) {
            hVar.f(bdUniqueId);
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.Z(bdUniqueId);
        }
    }

    public void setViewForeground() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.n;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.v);
            this.n.s(this.v);
            this.v.c();
        }
        if (this.t) {
            this.t = false;
            if (ListUtils.isEmpty(this.j.a())) {
                this.f17172g.loadData();
            }
        }
    }

    public void t() {
        this.i.setSelection(0);
        y();
        ScrollFragmentTabHost.q qVar = this.v;
        if (qVar != null) {
            qVar.c();
        }
    }

    public void u(@NonNull d.b.i0.z0.e.a.f.a aVar) {
        if (this.q == null) {
            this.q = new HotTopicHeaderView(getContext());
        }
        this.i.setHeaderView(this.q);
        this.q.setOnItemCoverListener(this.s);
        this.q.setOnTabSelectedListener(this.r);
        this.q.setData(aVar.getResData());
    }

    public void v(boolean z) {
        if (n()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.b.h0.d0.g(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.l.h();
            this.l.q(height);
            this.l.onChangeSkinType();
        }
        this.l.attachView(this, z);
    }

    public void w(boolean z) {
        if (o()) {
            return;
        }
        if (this.m == null) {
            this.m = new d.b.h0.d0.h(getContext(), new c());
        }
        this.m.attachView(this, z);
        this.m.o();
    }

    public void x() {
        this.i.setNextPage(this.p);
        this.p.f();
        this.p.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.p.B(getResources().getString(R.string.really_great), l.g(getContext(), R.dimen.tbds158));
    }

    public void y() {
        this.f17173h.setRefreshing(true);
    }

    public void z() {
        this.f17173h.setRefreshing(false);
    }
}
