package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.a.j;
import d.b.i0.m.f;
import d.b.i0.r.q.l;
/* loaded from: classes4.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17029e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f17030f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f17031g;

    /* renamed from: h  reason: collision with root package name */
    public f f17032h;
    public d.b.i0.r.w.b.d<l> i;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.m.c {
        public a() {
        }

        @Override // d.b.i0.m.c
        public void a(View view, boolean z, Object obj) {
            if (!z || HomePageTabFeedHeaderView.this.f17030f == null) {
                return;
            }
            HomePageTabFeedHeaderView.this.f17030f.d();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.m.c {
        public b() {
        }

        @Override // d.b.i0.m.c
        public void a(View view, boolean z, Object obj) {
            if (z) {
                d.b.j0.a1.i.b.b("c13751");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<l> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: b */
        public void c(View view, l lVar, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: d */
        public void a(View view, l lVar, int i, long j) {
            d.b.j0.a1.i.b.a("c13751", lVar, i + 1);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.i0.r.w.b.d<l> {
        public d() {
        }

        @Override // d.b.i0.r.w.b.d
        public void b(int i, String str) {
            l lVar = new l();
            lVar.g(str);
            d.b.j0.a1.i.b.a("c13750", lVar, i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.r.w.b.d
        /* renamed from: c */
        public void a(int i, l lVar) {
            d.b.j0.a1.i.b.c("c13750", lVar, i);
        }
    }

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.f17032h = new c();
        this.i = new d();
        b();
    }

    public void b() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.f17029e = (TbPageContext) j.a(getContext());
    }

    public void c(int i) {
        AutoBannerLayout autoBannerLayout = this.f17030f;
        if (autoBannerLayout != null) {
            autoBannerLayout.onChangeSkinType(this.f17029e, i);
        }
        GridIconLayout gridIconLayout = this.f17031g;
        if (gridIconLayout != null) {
            gridIconLayout.onChangeSkinType(this.f17029e, i);
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setData(d.b.j0.a1.i.e.c cVar) {
        if (cVar == null) {
            return;
        }
        setPadding(0, d.b.c.e.p.l.g(getContext(), R.dimen.tbds44), 0, d.b.c.e.p.l.g(getContext(), R.dimen.tbds60));
        if (this.f17030f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f17030f = autoBannerLayout;
            autoBannerLayout.setMarqueenTime(3000L);
            this.f17030f.setOnCoverViewCallback(this.i);
            this.f17030f.setBannerHeight(d.b.c.e.p.l.g(getContext(), R.dimen.tbds328));
            int g2 = d.b.c.e.p.l.g(getContext(), R.dimen.tbds44);
            this.f17030f.setPadding(g2, 0, g2, 0);
            addView(this.f17030f);
            this.f17030f.setIWindowChangedListener(new a());
        }
        this.f17030f.a(cVar.f53320d);
        if (this.f17031g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f17031g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f17032h);
            addView(this.f17031g);
            this.f17031g.setIWindowChangedListener(new b());
            this.f17031g.setPadding(0, d.b.c.e.p.l.g(getContext(), R.dimen.tbds61), 0, 0);
            this.f17031g.setVerticalSpace(d.b.c.e.p.l.g(getContext(), R.dimen.tbds61));
            this.f17031g.setMaxItem(10);
        }
        this.f17031g.a(cVar.f53321e);
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17032h = new c();
        this.i = new d();
        b();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17032h = new c();
        this.i = new d();
        b();
    }
}
