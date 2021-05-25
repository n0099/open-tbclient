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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.n0.d1.f.c;
import d.a.n0.z.t;
/* loaded from: classes4.dex */
public class HotTopicView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f16854e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f16855f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.g f16856g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.d1.a.d f16857h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.d0.g f16858i;
    public h j;
    public d.a.n0.d1.b.d k;
    public d.a.n0.d1.c.e l;
    public c.f m;
    public int n;
    public PbListView o;
    public int p;
    public f.g q;
    public AbsListView.OnScrollListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public View u;
    public d.a.n0.d1.f.c v;
    public int w;
    public int x;
    public g y;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                HotTopicView.this.k.i();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
                ((HotTopicActivity) HotTopicView.this.f16854e.getOrignalPage()).loadHotTopicData();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            HotTopicView.this.k.h(true);
            HotTopicView.this.f16855f.A(0L);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            HotTopicView.this.k.e(i2, i3);
            if (HotTopicView.this.m != null) {
                HotTopicView.this.m.onScroll(absListView, i2, i3, i4);
            }
            HotTopicView.this.I(absListView, i2);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 0) {
                HotTopicView.this.k.g();
                t.b().c();
            }
            if (HotTopicView.this.m != null) {
                HotTopicView.this.m.onScrollStateChanged(absListView, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || HotTopicView.this.l == null || HotTopicView.this.l.k() == null || HotTopicView.this.l.k().f52604e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData o = HotTopicView.this.o(((Long) data).longValue());
                if (o != null) {
                    o.followNum++;
                    o.setIsLiked(true);
                    HotTopicView.this.l.k().f52605f = true;
                    HotTopicView.this.f16857h.d(HotTopicView.this.l);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || HotTopicView.this.l == null || HotTopicView.this.l.k() == null || HotTopicView.this.l.k().f52604e == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData o = HotTopicView.this.o(((Long) data).longValue());
                if (o != null) {
                    o.followNum--;
                    o.setIsLiked(false);
                    HotTopicView.this.l.k().f52605f = true;
                    HotTopicView.this.f16857h.d(HotTopicView.this.l);
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
            if (view != HotTopicView.this.f16855f || HotTopicView.this.k == null) {
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
                ((HotTopicActivity) HotTopicView.this.f16854e.getOrignalPage()).loadHotTopicData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f16865e;

        public g(int i2) {
            this.f16865e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.f16855f.smoothScrollBy(Math.abs(this.f16865e), 1);
            HotTopicView.this.l();
        }
    }

    public HotTopicView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = 0;
        this.q = new a();
        this.r = new b();
        this.s = new c(2001335);
        this.t = new d(2001336);
        s(context);
    }

    private int getLoadingViewTopMargin() {
        d.a.n0.d1.f.c cVar = this.v;
        if (cVar == null || cVar.s() == null) {
            return 0;
        }
        return this.v.t() + (((getHeight() - this.v.t()) - l.g(getContext(), R.dimen.tbds304)) / 2);
    }

    private int getTopMargin() {
        d.a.n0.d1.f.c cVar = this.v;
        if (cVar == null || cVar.s() == null) {
            return 0;
        }
        return (int) Math.abs(this.v.t() + this.v.s().getY());
    }

    public void A(d.a.n0.d1.c.e eVar) {
        if (this.f16857h == null) {
            return;
        }
        if (eVar == null) {
            eVar = new d.a.n0.d1.c.e();
        }
        this.l = eVar;
        this.f16857h.c(eVar.n());
        this.f16857h.d(eVar);
        this.f16855f.setVisibility(0);
        if (ListUtils.isEmpty(eVar.i())) {
            return;
        }
        SkinManager.setBackgroundColor(this.f16855f, R.color.CAM_X0204);
    }

    public void B() {
        d.a.n0.d1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.d(false);
        }
    }

    public void C(int i2) {
        BdTypeListView bdTypeListView = this.f16855f;
        if (bdTypeListView == null) {
            return;
        }
        bdTypeListView.smoothScrollBy(i2, 1);
        l();
    }

    public void D(float f2) {
        d.a.n0.d1.c.e eVar;
        if (this.f16855f == null || (eVar = this.l) == null || eVar.k() == null) {
            return;
        }
        this.f16855f.setSelection(0);
        this.y = new g((int) f2);
        d.a.c.e.m.e.a().post(this.y);
    }

    public void E() {
        PbListView pbListView;
        BdTypeListView bdTypeListView = this.f16855f;
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
        if (this.f16858i == null) {
            d.a.m0.d0.g gVar = new d.a.m0.d0.g(getContext());
            this.f16858i = gVar;
            gVar.q(getLoadingViewTopMargin());
            this.f16858i.h();
            this.f16858i.onChangeSkinType();
        }
        this.f16858i.attachView(this, z);
        this.f16855f.setVisibility(8);
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
        this.f16855f.setVisibility(8);
    }

    public void H() {
        PbListView pbListView;
        if (this.f16855f == null || (pbListView = this.o) == null) {
            return;
        }
        int i2 = this.p;
        if (i2 > 0) {
            pbListView.J(i2);
        }
        this.f16855f.setNextPage(this.o);
        this.o.f();
        this.o.A(getContext().getResources().getString(R.string.list_no_more));
    }

    public final void I(AbsListView absListView, int i2) {
        if (this.v == null) {
            return;
        }
        if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i2 == 0) {
            int abs = Math.abs(absListView.getChildAt(0).getTop());
            this.n = abs;
            if (abs > this.x && this.w <= 1) {
                y();
            } else if (this.n < this.x) {
                x();
            }
            this.x = this.n;
        }
        this.w = i2;
    }

    public BdTypeListView getListView() {
        return this.f16855f;
    }

    public final void j() {
        View view = new View(getContext());
        this.u = view;
        view.setId(R.id.view_header);
        this.u.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.f16855f.x(this.u, 0);
    }

    public void k(int i2) {
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        layoutParams.height = i2;
        this.u.setLayoutParams(layoutParams);
        l();
    }

    public final void l() {
        if (v()) {
            this.j.j(getTopMargin());
        }
        if (u()) {
            this.f16858i.q(getLoadingViewTopMargin());
        }
    }

    public void m(boolean z) {
        if (this.f16855f != null) {
            this.k.h(true);
            if (z) {
                this.f16855f.z();
            } else {
                this.f16855f.A(0L);
            }
        }
    }

    public void n() {
        d.a.m0.r.f0.g gVar = this.f16856g;
        if (gVar != null) {
            gVar.a(null);
        }
        d.a.n0.d1.b.d dVar = this.k;
        if (dVar != null) {
            dVar.c();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.y);
    }

    public final RelateForumItemData o(long j) {
        d.a.n0.d1.c.e eVar = this.l;
        if (eVar == null || eVar.k() == null || this.l.k().f52604e == null) {
            return null;
        }
        for (n nVar : this.l.k().f52604e) {
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
        BdTypeListView bdTypeListView = this.f16855f;
        if (bdTypeListView == null || this.o == null) {
            return;
        }
        bdTypeListView.setNextPage(null);
        this.o.i();
    }

    public void q() {
        d.a.n0.d1.f.c cVar;
        d.a.m0.d0.g gVar = this.f16858i;
        if (gVar != null) {
            gVar.dettachView(this);
            this.f16858i = null;
        }
        if (t() || (cVar = this.v) == null || cVar.s() == null) {
            return;
        }
        this.f16855f.smoothScrollBy((int) (-this.v.s().getY()), 1);
    }

    public void r() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(this);
            this.j = null;
        }
    }

    public final void s(Context context) {
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f16854e = (TbPageContext) a2;
        }
        if (this.f16854e == null) {
            return;
        }
        BdTypeListView bdTypeListView = new BdTypeListView(context);
        this.f16855f = bdTypeListView;
        bdTypeListView.setVerticalScrollBarEnabled(false);
        this.f16855f.setDividerHeight(0);
        this.f16855f.setSelector(17170445);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f16854e);
        this.f16856g = gVar;
        gVar.a(this.q);
        this.f16855f.setPullRefresh(this.f16856g);
        View view = new View(context);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
        this.f16855f.addFooterView(view);
        this.f16855f.setOnScrollListener(this.r);
        this.f16855f.setOnSrollToBottomListener(this.f16854e.getOrignalPage());
        this.f16855f.setOnTouchListener(new e());
        this.f16857h = new d.a.n0.d1.a.d(this.f16854e.getOrignalPage(), this.f16855f);
        addView(this.f16855f);
        ((FrameLayout.LayoutParams) this.f16855f.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
        this.k = new d.a.n0.d1.b.d(this.f16854e, this.f16855f);
        this.f16854e.registerListener(this.s);
        this.f16854e.registerListener(this.t);
        j();
        PbListView pbListView = new PbListView(context);
        this.o = pbListView;
        pbListView.a();
        this.o.o(R.color.CAM_X0205);
        this.o.v();
        this.o.C(SkinManager.getColor(R.color.CAM_X0109));
        this.o.y(R.color.CAM_X0110);
    }

    public void setMainView(d.a.n0.d1.f.c cVar) {
        this.v = cVar;
    }

    public void setScrollCallback(c.f fVar) {
        this.m = fVar;
    }

    public final boolean t() {
        return this.v.s() != null && this.v.s().getY() == 0.0f;
    }

    public boolean u() {
        d.a.m0.d0.g gVar = this.f16858i;
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

    public void w(int i2) {
        d.a.m0.r.f0.g gVar = this.f16856g;
        if (gVar != null) {
            gVar.I(i2);
        }
        d.a.m0.d0.g gVar2 = this.f16858i;
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
            this.o.d(i2);
        }
        d.a.n0.d1.a.d dVar = this.f16857h;
        if (dVar != null) {
            dVar.b();
        }
        SkinManager.setBackgroundColor(this.f16855f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public final void x() {
        if (t()) {
            return;
        }
        this.v.P(this.f16855f, Math.min(this.n, this.v.v()));
    }

    public final void y() {
        d.a.n0.d1.f.c cVar = this.v;
        cVar.P(this.f16855f, Math.min(this.n, cVar.v()));
    }

    public void z() {
        d.a.n0.d1.b.d dVar = this.k;
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
