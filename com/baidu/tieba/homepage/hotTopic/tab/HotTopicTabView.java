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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.n0.b1.f.a.d.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HotTopicTabView extends FrameLayout implements f.g {

    /* renamed from: e  reason: collision with root package name */
    public int f16405e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f16406f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.f.a.b f16407g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f16408h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f16409i;
    public h j;
    public g k;
    public d.a.m0.d0.g l;
    public d.a.m0.d0.h m;
    public ScrollFragmentTabHost n;
    public int o;
    public PbListView p;
    public HotTopicHeaderView q;
    public TabLayout.OnTabSelectedListener r;
    public d.a.m0.m.f s;
    public boolean t;
    public RecyclerView.OnScrollListener u;
    public ScrollFragmentTabHost.s v;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (HotTopicTabView.this.o == i2 || HotTopicTabView.this.n == null) {
                return;
            }
            HotTopicTabView.this.o = i2;
            if (HotTopicTabView.this.o == 1) {
                HotTopicTabView.this.n.U();
            } else if (HotTopicTabView.this.r(recyclerView)) {
                HotTopicTabView.this.n.x();
            } else {
                HotTopicTabView.this.n.U();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ScrollFragmentTabHost.s {
        public b() {
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void c() {
            if (HotTopicTabView.this.n != null) {
                HotTopicTabView.this.o = -1;
                HotTopicTabView hotTopicTabView = HotTopicTabView.this;
                if (hotTopicTabView.r(hotTopicTabView.f16409i)) {
                    HotTopicTabView.this.n.x();
                } else {
                    HotTopicTabView.this.n.U();
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
            if (!j.A() || HotTopicTabView.this.f16407g == null) {
                return;
            }
            HotTopicTabView.this.u(false);
            HotTopicTabView.this.f16407g.loadData();
        }
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f16405e = 3;
        this.o = -1;
        this.u = new a();
        this.v = new b();
        this.f16406f = tbPageContext;
        l(tbPageContext.getPageActivity());
        m();
        q();
    }

    public void g() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.n;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.R(this.v);
        }
        y();
        h();
        i();
        this.t = true;
    }

    public void h() {
        d.a.m0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.dettachView(this);
            this.l = null;
        }
    }

    public void i() {
        d.a.m0.d0.h hVar = this.m;
        if (hVar != null) {
            hVar.dettachView(this);
            this.m = null;
        }
    }

    public void k() {
        this.f16409i.setNextPage(null);
    }

    public final void l(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.f16408h = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        g gVar = new g(this.f16406f);
        this.k = gVar;
        this.f16408h.setProgressView(gVar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.f16409i = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f16409i.setFadingEdgeLength(0);
        this.f16409i.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f16409i.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.j = new h(this.f16406f, this.f16409i);
        PbListView pbListView = new PbListView(this.f16406f.getPageActivity());
        this.p = pbListView;
        pbListView.a();
        this.p.o(R.color.CAM_X0205);
        this.p.y(R.color.CAM_X0111);
    }

    public final void m() {
        this.f16409i.addOnScrollListener(this.u);
        this.k.a(this);
    }

    public boolean n() {
        d.a.m0.d0.g gVar = this.l;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean o() {
        d.a.m0.d0.h hVar = this.m;
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

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.f16407g.loadData();
    }

    public boolean p() {
        HotTopicHeaderView hotTopicHeaderView = this.q;
        return (hotTopicHeaderView == null || hotTopicHeaderView.getParent() == null) ? false : true;
    }

    public void q() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16405e) {
            return;
        }
        this.f16405e = skinType;
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(skinType);
        }
        d.a.m0.d0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        d.a.m0.d0.h hVar = this.m;
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f16409i;
        if (bdTypeRecyclerView != null) {
            d.a.m0.r.u.c.d(bdTypeRecyclerView).f(R.color.CAM_X0202);
        }
    }

    public final boolean r(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return true;
        }
        return !recyclerView.canScrollVertically(-1);
    }

    public void s() {
        this.f16409i.setSelection(0);
        x();
        ScrollFragmentTabHost.s sVar = this.v;
        if (sVar != null) {
            sVar.c();
        }
    }

    public void setData(@NonNull d.a.n0.b1.f.a.f.a aVar) {
        t(aVar);
        setListData(aVar.getDataList());
    }

    public void setListData(@NonNull List<n> list) {
        this.j.d(list);
    }

    public void setOnItemCoverListener(d.a.m0.m.f fVar) {
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

    public void setPresenter(d.a.n0.b1.f.a.b bVar) {
        this.f16407g = bVar;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.n = scrollFragmentTabHost;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.R(this.v);
            this.n.v(this.v);
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
            scrollFragmentTabHost.R(this.v);
            this.n.v(this.v);
            this.v.c();
        }
        if (this.t) {
            this.t = false;
            if (ListUtils.isEmpty(this.j.a())) {
                this.f16407g.loadData();
            }
        }
    }

    public void t(@NonNull d.a.n0.b1.f.a.f.a aVar) {
        if (this.q == null) {
            this.q = new HotTopicHeaderView(getContext());
        }
        this.f16409i.setHeaderView(this.q);
        this.q.setOnItemCoverListener(this.s);
        this.q.setOnTabSelectedListener(this.r);
        this.q.setData(aVar.getResData());
    }

    public void u(boolean z) {
        if (n()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.m0.d0.g(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.l.h();
            this.l.q(height);
            this.l.onChangeSkinType();
        }
        this.l.attachView(this, z);
    }

    public void v(boolean z) {
        if (o()) {
            return;
        }
        if (this.m == null) {
            this.m = new d.a.m0.d0.h(getContext(), new c());
        }
        this.m.attachView(this, z);
        this.m.o();
    }

    public void w() {
        this.f16409i.setNextPage(this.p);
        this.p.f();
        this.p.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.p.B(getResources().getString(R.string.really_great), l.g(getContext(), R.dimen.tbds158));
    }

    public void x() {
        this.f16408h.setRefreshing(true);
    }

    public void y() {
        this.f16408h.setRefreshing(false);
    }
}
