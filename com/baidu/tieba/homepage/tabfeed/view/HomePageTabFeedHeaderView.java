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
import d.a.c.a.j;
import d.a.i0.m.f;
import d.a.i0.r.q.l;
/* loaded from: classes4.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17307e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f17308f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f17309g;

    /* renamed from: h  reason: collision with root package name */
    public f f17310h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.r.w.b.d<l> f17311i;

    /* loaded from: classes4.dex */
    public class a implements d.a.i0.m.c {
        public a() {
        }

        @Override // d.a.i0.m.c
        public void a(View view, boolean z, Object obj) {
            if (!z || HomePageTabFeedHeaderView.this.f17308f == null) {
                return;
            }
            HomePageTabFeedHeaderView.this.f17308f.d();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.i0.m.c {
        public b() {
        }

        @Override // d.a.i0.m.c
        public void a(View view, boolean z, Object obj) {
            if (z) {
                d.a.j0.a1.i.b.b("c13751");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<l> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: b */
        public void c(View view, l lVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: d */
        public void a(View view, l lVar, int i2, long j) {
            d.a.j0.a1.i.b.a("c13751", lVar, i2 + 1);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.i0.r.w.b.d<l> {
        public d() {
        }

        @Override // d.a.i0.r.w.b.d
        public void b(int i2, String str) {
            l lVar = new l();
            lVar.g(str);
            d.a.j0.a1.i.b.a("c13750", lVar, i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, l lVar) {
            d.a.j0.a1.i.b.c("c13750", lVar, i2);
        }
    }

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.f17310h = new c();
        this.f17311i = new d();
        b();
    }

    public void b() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.f17307e = (TbPageContext) j.a(getContext());
    }

    public void c(int i2) {
        AutoBannerLayout autoBannerLayout = this.f17308f;
        if (autoBannerLayout != null) {
            autoBannerLayout.onChangeSkinType(this.f17307e, i2);
        }
        GridIconLayout gridIconLayout = this.f17309g;
        if (gridIconLayout != null) {
            gridIconLayout.onChangeSkinType(this.f17307e, i2);
        }
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setData(d.a.j0.a1.i.e.c cVar) {
        if (cVar == null) {
            return;
        }
        setPadding(0, d.a.c.e.p.l.g(getContext(), R.dimen.tbds44), 0, d.a.c.e.p.l.g(getContext(), R.dimen.tbds60));
        if (this.f17308f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f17308f = autoBannerLayout;
            autoBannerLayout.setMarqueenTime(3000L);
            this.f17308f.setOnCoverViewCallback(this.f17311i);
            this.f17308f.setBannerHeight(d.a.c.e.p.l.g(getContext(), R.dimen.tbds328));
            int g2 = d.a.c.e.p.l.g(getContext(), R.dimen.tbds44);
            this.f17308f.setPadding(g2, 0, g2, 0);
            addView(this.f17308f);
            this.f17308f.setIWindowChangedListener(new a());
        }
        this.f17308f.a(cVar.f51040d);
        if (this.f17309g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f17309g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f17310h);
            addView(this.f17309g);
            this.f17309g.setIWindowChangedListener(new b());
            this.f17309g.setPadding(0, d.a.c.e.p.l.g(getContext(), R.dimen.tbds61), 0, 0);
            this.f17309g.setVerticalSpace(d.a.c.e.p.l.g(getContext(), R.dimen.tbds61));
            this.f17309g.setMaxItem(10);
        }
        this.f17309g.a(cVar.f51041e);
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17310h = new c();
        this.f17311i = new d();
        b();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17310h = new c();
        this.f17311i = new d();
        b();
    }
}
