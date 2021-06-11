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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicListView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16702e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f16703f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.b1.k.b.a f16704g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f16705h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f16706i;
    public d.a.n0.b1.k.b.b.a j;
    public g k;
    public d.a.m0.d0.g l;
    public h m;
    public ScrollFragmentTabHost n;
    public PbListView o;
    public RecyclerView.OnScrollListener p;
    public ScrollFragmentTabHost.s q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || TopicListView.this.f16704g == null) {
                return;
            }
            TopicListView.this.f16706i.setVisibility(0);
            TopicListView.this.f16704g.loadData();
        }
    }

    public void c() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.n;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.R(this.q);
        }
        this.f16706i.removeOnScrollListener(this.p);
        p();
        d();
        e();
    }

    public void d() {
        d.a.m0.d0.g gVar = this.l;
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
        this.f16706i.removeOnScrollListener(this.p);
        this.f16706i.addOnScrollListener(this.p);
    }

    public boolean g() {
        d.a.m0.d0.g gVar = this.l;
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
        if (skinType == this.f16702e) {
            return;
        }
        this.f16702e = skinType;
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(skinType);
        }
        d.a.m0.d0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.a.n0.b1.k.b.b.a aVar = this.j;
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
        this.f16706i.setSelection(0);
        o();
        ScrollFragmentTabHost.s sVar = this.q;
        if (sVar != null) {
            sVar.c();
        }
    }

    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f16706i;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void l(boolean z) {
        if (g()) {
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

    public void m(boolean z) {
        if (h()) {
            return;
        }
        if (this.m == null) {
            this.m = new h(getContext(), new a());
        }
        this.m.attachView(this, z);
        this.m.o();
        this.f16706i.setVisibility(8);
    }

    public void n() {
        this.f16706i.setNextPage(this.o);
        this.o.f();
        this.o.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.o.r(l.g(this.f16703f.getPageActivity(), R.dimen.tbds150));
        this.o.A(getResources().getString(R.string.really_great));
    }

    public void o() {
        this.f16705h.setRefreshing(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    public void p() {
        this.f16705h.setRefreshing(false);
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
            gVar2.a(gVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.a.n0.b1.k.b.b.a aVar = this.j;
        if (aVar != null) {
            aVar.c(bdUniqueId);
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.Z(bdUniqueId);
        }
    }

    public void setPresenter(d.a.n0.b1.k.b.a aVar) {
        this.f16704g = aVar;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.n = scrollFragmentTabHost;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.R(this.q);
            this.n.v(this.q);
        }
    }

    public void setViewForeground() {
        ScrollFragmentTabHost scrollFragmentTabHost = this.n;
        if (scrollFragmentTabHost != null) {
            scrollFragmentTabHost.R(this.q);
            this.n.v(this.q);
            this.q.c();
        }
    }
}
