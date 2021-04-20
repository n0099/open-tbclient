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
import d.b.h0.m.f;
import d.b.h0.r.q.l;
/* loaded from: classes4.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17021e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f17022f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f17023g;

    /* renamed from: h  reason: collision with root package name */
    public f f17024h;
    public d.b.h0.r.w.b.d<l> i;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.m.c {
        public a() {
        }

        @Override // d.b.h0.m.c
        public void a(View view, boolean z, Object obj) {
            if (!z || HomePageTabFeedHeaderView.this.f17022f == null) {
                return;
            }
            HomePageTabFeedHeaderView.this.f17022f.d();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.h0.m.c {
        public b() {
        }

        @Override // d.b.h0.m.c
        public void a(View view, boolean z, Object obj) {
            if (z) {
                d.b.i0.a1.i.b.b("c13751");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<l> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, l lVar, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        public void a(View view, l lVar, int i, long j) {
            d.b.i0.a1.i.b.a("c13751", lVar, i + 1);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.h0.r.w.b.d<l> {
        public d() {
        }

        @Override // d.b.h0.r.w.b.d
        public void b(int i, String str) {
            l lVar = new l();
            lVar.g(str);
            d.b.i0.a1.i.b.a("c13750", lVar, i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.r.w.b.d
        /* renamed from: c */
        public void a(int i, l lVar) {
            d.b.i0.a1.i.b.c("c13750", lVar, i);
        }
    }

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.f17024h = new c();
        this.i = new d();
        b();
    }

    public void b() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.f17021e = (TbPageContext) j.a(getContext());
    }

    public void c(int i) {
        AutoBannerLayout autoBannerLayout = this.f17022f;
        if (autoBannerLayout != null) {
            autoBannerLayout.onChangeSkinType(this.f17021e, i);
        }
        GridIconLayout gridIconLayout = this.f17023g;
        if (gridIconLayout != null) {
            gridIconLayout.onChangeSkinType(this.f17021e, i);
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

    public void setData(d.b.i0.a1.i.e.c cVar) {
        if (cVar == null) {
            return;
        }
        setPadding(0, d.b.c.e.p.l.g(getContext(), R.dimen.tbds44), 0, d.b.c.e.p.l.g(getContext(), R.dimen.tbds60));
        if (this.f17022f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f17022f = autoBannerLayout;
            autoBannerLayout.setMarqueenTime(3000L);
            this.f17022f.setOnCoverViewCallback(this.i);
            this.f17022f.setBannerHeight(d.b.c.e.p.l.g(getContext(), R.dimen.tbds328));
            int g2 = d.b.c.e.p.l.g(getContext(), R.dimen.tbds44);
            this.f17022f.setPadding(g2, 0, g2, 0);
            addView(this.f17022f);
            this.f17022f.setIWindowChangedListener(new a());
        }
        this.f17022f.a(cVar.f52899d);
        if (this.f17023g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f17023g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f17024h);
            addView(this.f17023g);
            this.f17023g.setIWindowChangedListener(new b());
            this.f17023g.setPadding(0, d.b.c.e.p.l.g(getContext(), R.dimen.tbds61), 0, 0);
            this.f17023g.setVerticalSpace(d.b.c.e.p.l.g(getContext(), R.dimen.tbds61));
            this.f17023g.setMaxItem(10);
        }
        this.f17023g.a(cVar.f52900e);
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17024h = new c();
        this.i = new d();
        b();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17024h = new c();
        this.i = new d();
        b();
    }
}
