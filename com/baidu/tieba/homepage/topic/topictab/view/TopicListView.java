package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicListView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17107e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f17108f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.a1.j.b.a f17109g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f17110h;
    public BdTypeRecyclerView i;
    public d.b.i0.a1.j.b.b.a j;
    public g k;
    public d.b.h0.d0.g l;
    public h m;
    public ScrollFragmentTabHost n;
    public PbListView o;
    public RecyclerView.OnScrollListener p;
    public ScrollFragmentTabHost.q q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || TopicListView.this.f17109g == null) {
                return;
            }
            TopicListView.this.i.setVisibility(0);
            TopicListView.this.f17109g.loadData();
        }
    }

    public void c() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.n;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.q);
        }
        this.i.removeOnScrollListener(this.p);
        p();
        d();
        e();
    }

    public void d() {
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.dettachView(this);
            this.l = null;
        }
    }

    public void e() {
        h hVar = this.m;
        if (hVar != null) {
            hVar.dettachView(this);
            this.m = null;
        }
    }

    public void f() {
        this.i.removeOnScrollListener(this.p);
        this.i.addOnScrollListener(this.p);
    }

    public boolean g() {
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean h() {
        h hVar = this.m;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void i() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17107e) {
            return;
        }
        this.f17107e = skinType;
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(skinType);
        }
        d.b.h0.d0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.b.i0.a1.j.b.b.a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
        PbListView pbListView = this.o;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.o.o(R.color.CAM_X0205);
        }
    }

    public void j() {
        this.i.setSelection(0);
        o();
        ScrollFragmentTabHost.q qVar = this.q;
        if (qVar != null) {
            qVar.c();
        }
    }

    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView = this.i;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void l(boolean z) {
        if (g()) {
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

    public void m(boolean z) {
        if (h()) {
            return;
        }
        if (this.m == null) {
            this.m = new h(getContext(), new a());
        }
        this.m.attachView(this, z);
        this.m.o();
        this.i.setVisibility(8);
    }

    public void n() {
        this.i.setNextPage(this.o);
        this.o.f();
        this.o.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.o.r(l.g(this.f17108f.getPageActivity(), R.dimen.tbds150));
        this.o.A(getResources().getString(R.string.really_great));
    }

    public void o() {
        this.f17110h.setRefreshing(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    public void p() {
        this.f17110h.setRefreshing(false);
    }

    public void setData(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.j.b(list);
    }

    public void setListPullRefreshListener(f.g gVar) {
        g gVar2 = this.k;
        if (gVar2 != null) {
            gVar2.b(gVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.b.i0.a1.j.b.b.a aVar = this.j;
        if (aVar != null) {
            aVar.c(bdUniqueId);
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.Z(bdUniqueId);
        }
    }

    public void setPresenter(d.b.i0.a1.j.b.a aVar) {
        this.f17109g = aVar;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.n = scrollFragmentTabHost;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.q);
            this.n.s(this.q);
        }
    }

    public void setViewForeground() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.n;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.N(this.q);
            this.n.s(this.q);
            this.q.c();
        }
    }
}
