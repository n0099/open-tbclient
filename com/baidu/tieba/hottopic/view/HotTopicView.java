package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.i0.c1.f.c;
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class HotTopicView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f17320e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f17321f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f17322g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c1.a.d f17323h;
    public d.b.h0.d0.g i;
    public h j;
    public d.b.i0.c1.b.d k;
    public d.b.i0.c1.c.e l;
    public c.f m;
    public int n;
    public PbListView o;
    public int p;
    public f.g q;
    public AbsListView.OnScrollListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public View u;
    public d.b.i0.c1.f.c v;
    public int w;
    public int x;
    public g y;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                HotTopicView.this.k.i();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                ((HotTopicActivity) HotTopicView.this.f17320e.getOrignalPage()).loadHotTopicData();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            HotTopicView.this.k.h(true);
            HotTopicView.this.f17321f.A(0L);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            HotTopicView.this.k.e(i, i2);
            if (HotTopicView.this.m != null) {
                HotTopicView.this.m.onScroll(absListView, i, i2, i3);
            }
            HotTopicView.this.I(absListView, i);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                HotTopicView.this.k.g();
                t.b().c();
            }
            if (HotTopicView.this.m != null) {
                HotTopicView.this.m.onScrollStateChanged(absListView, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || HotTopicView.this.l == null || HotTopicView.this.l.k() == null || HotTopicView.this.l.k().f53540e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData o = HotTopicView.this.o(((Long) data).longValue());
                if (o != null) {
                    o.followNum++;
                    o.setIsLiked(true);
                    HotTopicView.this.l.k().f53541f = true;
                    HotTopicView.this.f17323h.d(HotTopicView.this.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || HotTopicView.this.l == null || HotTopicView.this.l.k() == null || HotTopicView.this.l.k().f53540e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData o = HotTopicView.this.o(((Long) data).longValue());
                if (o != null) {
                    o.followNum--;
                    o.setIsLiked(false);
                    HotTopicView.this.l.k().f53541f = true;
                    HotTopicView.this.f17323h.d(HotTopicView.this.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view != HotTopicView.this.f17321f || HotTopicView.this.k == null) {
                return false;
            }
            HotTopicView.this.k.f(motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                HotTopicView.this.r();
                HotTopicView.this.F(true);
                ((HotTopicActivity) HotTopicView.this.f17320e.getOrignalPage()).loadHotTopicData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f17330e;

        public g(int i) {
            this.f17330e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.f17321f.smoothScrollBy(Math.abs(this.f17330e), 1);
            HotTopicView.this.l();
        }
    }

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = 0;
        this.q = new a();
        this.r = new b();
        this.s = new c(2001335);
        this.t = new d(2001336);
        s(context);
    }

    private int getLoadingViewTopMargin() {
        d.b.i0.c1.f.c cVar = this.v;
        if (cVar == null || cVar.s() == null) {
            return 0;
        }
        return this.v.t() + (((getHeight() - this.v.t()) - l.g(getContext(), R.dimen.tbds304)) / 2);
    }

    private int getTopMargin() {
        d.b.i0.c1.f.c cVar = this.v;
        if (cVar == null || cVar.s() == null) {
            return 0;
        }
        return (int) Math.abs(this.v.t() + this.v.s().getY());
    }

    public void A(d.b.i0.c1.c.e eVar) {
        if (this.f17323h == null) {
            return;
        }
        if (eVar == null) {
            eVar = new d.b.i0.c1.c.e();
        }
        this.l = eVar;
        this.f17323h.c(eVar.n());
        this.f17323h.d(eVar);
        this.f17321f.setVisibility(0);
        if (ListUtils.isEmpty(eVar.i())) {
            return;
        }
        SkinManager.setBackgroundColor(this.f17321f, R.color.CAM_X0204);
    }

    public void B() {
        d.b.i0.c1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.d(false);
        }
    }

    public void C(int i) {
        BdTypeListView bdTypeListView = this.f17321f;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.smoothScrollBy(i, 1);
        l();
    }

    public void D(float f2) {
        d.b.i0.c1.c.e eVar;
        if (this.f17321f == null || (eVar = this.l) == null || eVar.k() == null) {
            return;
        }
        this.f17321f.setSelection(0);
        this.y = new g((int) f2);
        d.b.c.e.m.e.a().post(this.y);
    }

    public void E() {
        PbListView pbListView;
        BdTypeListView bdTypeListView = this.f17321f;
        if (bdTypeListView == null || (pbListView = this.o) == null) {
            return;
        }
        bdTypeListView.setNextPage(pbListView);
        this.o.E(R.dimen.tbfontsize33);
        this.o.r(l.g(getContext(), R.dimen.tbds182));
        this.o.O();
    }

    public void F(boolean z) {
        if (u()) {
            return;
        }
        if (this.i == null) {
            d.b.h0.d0.g gVar = new d.b.h0.d0.g(getContext());
            this.i = gVar;
            gVar.q(getLoadingViewTopMargin());
            this.i.h();
            this.i.onChangeSkinType();
        }
        this.i.attachView(this, z);
        this.f17321f.setVisibility(8);
    }

    public void G(String str, boolean z) {
        if (v()) {
            return;
        }
        if (this.j == null) {
            this.j = new h(getContext(), new f());
        }
        this.j.j(getTopMargin());
        this.j.attachView(this, z);
        this.j.o();
        this.f17321f.setVisibility(8);
    }

    public void H() {
        PbListView pbListView;
        if (this.f17321f == null || (pbListView = this.o) == null) {
            return;
        }
        int i = this.p;
        if (i > 0) {
            pbListView.J(i);
        }
        this.f17321f.setNextPage(this.o);
        this.o.f();
        this.o.A(getContext().getResources().getString(R.string.list_no_more));
    }

    public final void I(AbsListView absListView, int i) {
        if (this.v == null) {
            return;
        }
        if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
            int abs = Math.abs(absListView.getChildAt(0).getTop());
            this.n = abs;
            if (abs > this.x && this.w <= 1) {
                y();
            } else if (this.n < this.x) {
                x();
            }
            this.x = this.n;
        }
        this.w = i;
    }

    public BdTypeListView getListView() {
        return this.f17321f;
    }

    public final void j() {
        View view = new View(getContext());
        this.u = view;
        view.setId(R.id.view_header);
        this.u.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.f17321f.x(this.u, 0);
    }

    public void k(int i) {
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        layoutParams.height = i;
        this.u.setLayoutParams(layoutParams);
        l();
    }

    public final void l() {
        if (v()) {
            this.j.j(getTopMargin());
        }
        if (u()) {
            this.i.q(getLoadingViewTopMargin());
        }
    }

    public void m(boolean z) {
        if (this.f17321f != null) {
            this.k.h(true);
            if (z) {
                this.f17321f.z();
            } else {
                this.f17321f.A(0L);
            }
        }
    }

    public void n() {
        d.b.h0.r.f0.g gVar = this.f17322g;
        if (gVar != null) {
            gVar.b(null);
        }
        d.b.i0.c1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.c();
        }
        d.b.c.e.m.e.a().removeCallbacks(this.y);
    }

    public final RelateForumItemData o(long j) {
        d.b.i0.c1.c.e eVar = this.l;
        if (eVar == null || eVar.k() == null || this.l.k().f53540e == null) {
            return null;
        }
        for (n nVar : this.l.k().f53540e) {
            if (nVar != null && (nVar instanceof RelateForumItemData)) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                if (relateForumItemData.forumId == j) {
                    return relateForumItemData;
                }
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        n();
        super.onDetachedFromWindow();
    }

    public void p() {
        BdTypeListView bdTypeListView = this.f17321f;
        if (bdTypeListView == null || this.o == null) {
            return;
        }
        bdTypeListView.setNextPage(null);
        this.o.i();
    }

    public void q() {
        d.b.i0.c1.f.c cVar;
        d.b.h0.d0.g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this);
            this.i = null;
        }
        if (t() || (cVar = this.v) == null || cVar.s() == null) {
            return;
        }
        this.f17321f.smoothScrollBy((int) (-this.v.s().getY()), 1);
    }

    public void r() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this);
            this.j = null;
        }
    }

    public final void s(Context context) {
        d.b.c.a.f<?> a2 = d.b.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17320e = (TbPageContext) a2;
        }
        if (this.f17320e == null) {
            return;
        }
        BdTypeListView bdTypeListView = new BdTypeListView(context);
        this.f17321f = bdTypeListView;
        bdTypeListView.setVerticalScrollBarEnabled(false);
        this.f17321f.setDividerHeight(0);
        this.f17321f.setSelector(17170445);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f17320e);
        this.f17322g = gVar;
        gVar.b(this.q);
        this.f17321f.setPullRefresh(this.f17322g);
        View view = new View(context);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
        this.f17321f.addFooterView(view);
        this.f17321f.setOnScrollListener(this.r);
        this.f17321f.setOnSrollToBottomListener(this.f17320e.getOrignalPage());
        this.f17321f.setOnTouchListener(new e());
        this.f17323h = new d.b.i0.c1.a.d(this.f17320e.getOrignalPage(), this.f17321f);
        addView(this.f17321f);
        ((FrameLayout.LayoutParams) this.f17321f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
        this.k = new d.b.i0.c1.b.d(this.f17320e, this.f17321f);
        this.f17320e.registerListener(this.s);
        this.f17320e.registerListener(this.t);
        j();
        PbListView pbListView = new PbListView(context);
        this.o = pbListView;
        pbListView.a();
        this.o.o(R.color.CAM_X0205);
        this.o.v();
        this.o.C(SkinManager.getColor(R.color.CAM_X0109));
        this.o.y(R.color.CAM_X0110);
    }

    public void setMainView(d.b.i0.c1.f.c cVar) {
        this.v = cVar;
    }

    public void setScrollCallback(c.f fVar) {
        this.m = fVar;
    }

    public final boolean t() {
        return this.v.s() != null && this.v.s().getY() == 0.0f;
    }

    public boolean u() {
        d.b.h0.d0.g gVar = this.i;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean v() {
        h hVar = this.j;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void w(int i) {
        d.b.h0.r.f0.g gVar = this.f17322g;
        if (gVar != null) {
            gVar.I(i);
        }
        d.b.h0.d0.g gVar2 = this.i;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        PbListView pbListView = this.o;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.o.d(i);
        }
        d.b.i0.c1.a.d dVar = this.f17323h;
        if (dVar != null) {
            dVar.b();
        }
        SkinManager.setBackgroundColor(this.f17321f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public final void x() {
        if (t()) {
            return;
        }
        this.v.P(this.f17321f, Math.min(this.n, this.v.v()));
    }

    public final void y() {
        d.b.i0.c1.f.c cVar = this.v;
        cVar.P(this.f17321f, Math.min(this.n, cVar.v()));
    }

    public void z() {
        d.b.i0.c1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.d(true);
        }
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 0;
        this.q = new a();
        this.r = new b();
        this.s = new c(2001335);
        this.t = new d(2001336);
        s(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.p = 0;
        this.q = new a();
        this.r = new b();
        this.s = new c(2001335);
        this.t = new d(2001336);
        s(context);
    }
}
