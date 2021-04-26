package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.i0.d0.h;
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.j0.i0.k.c.f;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendView extends FrameLayout implements ForumTestView.c {

    /* renamed from: e  reason: collision with root package name */
    public int f15318e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15319f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.i0.k.a f15320g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendForumHeaderView f15321h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwipeRefreshLayout f15322i;
    public BdTypeRecyclerView j;
    public d.a.j0.i0.k.b.a k;
    public g l;
    public d.a.i0.d0.g m;
    public h n;
    public d.a.j0.i0.k.c.a o;
    public d.a.j0.i0.h.c p;
    public FrameLayout q;
    public long r;
    public int s;
    public int t;
    public List<f> u;
    public CustomMessageListener v;
    public CustomMessageListener w;
    public RecyclerView.OnScrollListener x;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (RecommendView.this.p != null) {
                RecommendView.this.p.W(TbSingleton.getInstance().getHotSearch());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Long) {
                Long l = (Long) customResponsedMessage.getData();
                if (RecommendView.this.o == null || l == null) {
                    return;
                }
                RecommendView.this.r = l.longValue();
                if (RecommendView.this.f15320g != null) {
                    RecommendView.this.f15320g.loadData();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f15325a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f15326b = 0;

        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (this.f15325a == i2 || RecommendView.this.p == null) {
                return;
            }
            this.f15325a = i2;
            if (i2 == 1) {
                return;
            }
            RecommendView.this.o(recyclerView);
            RecommendView.this.f15321h.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            this.f15326b += i3;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || RecommendView.this.f15320g == null) {
                return;
            }
            RecommendView.this.f15320g.loadData();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || RecommendView.this.f15320g == null) {
                return;
            }
            RecommendView.this.f15320g.loadData();
        }
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f15318e = 3;
        this.v = new a(2921396);
        this.w = new b(2921383);
        this.x = new c();
        this.f15319f = tbPageContext;
        this.s = UtilHelper.getStatusBarHeight() + l.g(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.t = l.g(tbPageContext.getPageActivity(), R.dimen.tbds114);
        j(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.w);
        tbPageContext.registerListener(this.v);
        m();
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.c
    public void a() {
        BdTypeRecyclerView bdTypeRecyclerView = this.j;
        if (bdTypeRecyclerView == null || ListUtils.isEmpty(bdTypeRecyclerView.getData()) || this.j.getData().size() != 1 || !(this.j.getData().get(0) instanceof d.a.j0.i0.k.c.e)) {
            return;
        }
        u();
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.c
    public void b(long j) {
        q(this.o, j);
    }

    public void h() {
        d.a.i0.d0.g gVar = this.m;
        if (gVar != null) {
            gVar.dettachView(this);
            this.m = null;
        }
    }

    public void i() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this);
            this.n = null;
        }
    }

    public final void j(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.f15322i = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        g gVar = new g(this.f15319f);
        this.l = gVar;
        this.f15322i.setProgressView(gVar);
        this.f15322i.setClipChildren(false);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.j = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.j.setFadingEdgeLength(0);
        this.j.setOverScrollMode(2);
        this.j.setClipChildren(false);
        this.j.addOnScrollListener(this.x);
        this.k = new d.a.j0.i0.k.b.a(this.f15319f, this.j);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f15322i.getLayoutParams();
        marginLayoutParams.topMargin = this.s - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.f15322i.setLayoutParams(marginLayoutParams);
        RecommendForumHeaderView recommendForumHeaderView = new RecommendForumHeaderView(this.f15319f);
        this.f15321h = recommendForumHeaderView;
        recommendForumHeaderView.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.f15319f.getPageActivity());
        frameLayout.addView(new View(this.f15319f.getPageActivity()), new FrameLayout.LayoutParams(-1, this.t));
        this.q = frameLayout;
    }

    public boolean k() {
        d.a.i0.d0.g gVar = this.m;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean l() {
        h hVar = this.n;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void m() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15318e) {
            return;
        }
        this.f15318e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        g gVar = this.l;
        if (gVar != null) {
            gVar.I(skinType);
        }
        d.a.i0.d0.g gVar2 = this.m;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.a.j0.i0.k.b.a aVar = this.k;
        if (aVar != null) {
            aVar.d();
        }
        RecommendForumHeaderView recommendForumHeaderView = this.f15321h;
        if (recommendForumHeaderView != null) {
            recommendForumHeaderView.f();
        }
        SkinManager.setBackgroundColor(this.f15322i, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
    }

    public void n() {
        BdTypeRecyclerView bdTypeRecyclerView = this.j;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.x);
        }
        v();
        h();
        i();
        RecommendForumHeaderView recommendForumHeaderView = this.f15321h;
        if (recommendForumHeaderView != null) {
            recommendForumHeaderView.h();
        }
    }

    public boolean o(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        n();
        super.onDetachedFromWindow();
    }

    public final void p(List<f> list) {
        this.j.removeHeaderView(this.q);
        this.j.removeHeaderView(this.f15321h);
        this.j.getHeaderViewsCount();
        this.j.s(this.f15321h);
        this.u = list;
        this.f15321h.setData(list);
        this.p.W(TbSingleton.getInstance().getHotSearch());
    }

    public final void q(d.a.j0.i0.k.c.a aVar, long j) {
        if (aVar == null) {
            return;
        }
        this.k.e(aVar.a(j, !ListUtils.isEmpty(this.u)));
    }

    public void r() {
        BdTypeRecyclerView bdTypeRecyclerView = this.j;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void s(boolean z) {
        if (k()) {
            return;
        }
        if (this.m == null) {
            this.m = new d.a.i0.d0.g(getContext());
            this.m.h();
            this.m.q((getHeight() - l.g(getContext(), R.dimen.tbds304)) / 2);
            this.m.onChangeSkinType();
        }
        this.m.attachView(this, z);
    }

    public void setData(d.a.j0.i0.k.c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.o = aVar;
        if (ListUtils.isEmpty(aVar.d()) && ListUtils.isEmpty(aVar.b(true))) {
            u();
            return;
        }
        r();
        List<f> f2 = aVar.f(this.r);
        this.r = 0L;
        f fVar = (f) ListUtils.getItem(f2, 1);
        if (fVar == null) {
            fVar = (f) ListUtils.getItem(f2, 0);
        }
        long j = fVar != null ? fVar.f55130a : 0L;
        p(f2);
        q(aVar, j);
    }

    public void setListPullRefreshListener(f.g gVar) {
        g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.a(gVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.a.j0.i0.k.b.a aVar = this.k;
        if (aVar != null) {
            aVar.f(bdUniqueId);
        }
        g gVar = this.l;
        if (gVar != null) {
            gVar.Z(bdUniqueId);
        }
        RecommendForumHeaderView recommendForumHeaderView = this.f15321h;
        if (recommendForumHeaderView != null) {
            recommendForumHeaderView.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(d.a.j0.i0.k.a aVar) {
        this.f15320g = aVar;
    }

    public void setTabViewController(d.a.j0.i0.h.c cVar) {
        this.p = cVar;
    }

    public void t(boolean z) {
        if (l()) {
            return;
        }
        if (this.n == null) {
            this.n = new h(getContext(), new d());
            this.n.j(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.n.m(this.f15319f.getString(R.string.refresh_view_title_text));
        this.n.i(R.drawable.new_pic_emotion_08);
        this.n.attachView(this, z);
        this.n.o();
        this.j.setVisibility(8);
    }

    public void u() {
        if (this.n == null) {
            this.n = new h(getContext(), new e());
            this.n.j(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.n.i(R.drawable.new_pic_emotion_08);
        this.n.m(this.f15319f.getString(R.string.recommend_forum_no_data));
        this.n.attachView(this, false);
        this.n.o();
        this.j.setVisibility(8);
    }

    public void v() {
        this.f15322i.setRefreshing(false);
    }
}
