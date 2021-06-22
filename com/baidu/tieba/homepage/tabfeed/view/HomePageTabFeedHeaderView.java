package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.n0.m.f;
import d.a.n0.r.q.k0;
import d.a.n0.r.q.l;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16690e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f16691f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f16692g;

    /* renamed from: h  reason: collision with root package name */
    public String f16693h;

    /* renamed from: i  reason: collision with root package name */
    public f f16694i;
    public d.a.n0.r.w.b.d<l> j;

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.m.c {
        public a() {
        }

        @Override // d.a.n0.m.c
        public void a(View view, boolean z, Object obj) {
            if (!z || HomePageTabFeedHeaderView.this.f16691f == null) {
                return;
            }
            HomePageTabFeedHeaderView.this.f16691f.d();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.m.c {
        public b() {
        }

        @Override // d.a.n0.m.c
        public void a(View view, boolean z, Object obj) {
            if (z) {
                d.a.o0.b1.j.c.c("c13751", HomePageTabFeedHeaderView.this.f16693h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<l> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: b */
        public void c(View view, l lVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: d */
        public void a(View view, l lVar, int i2, long j) {
            d.a.o0.b1.j.c.a("c13751", lVar, i2 + 1, HomePageTabFeedHeaderView.this.f16693h);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.n0.r.w.b.d<l> {
        public d() {
        }

        @Override // d.a.n0.r.w.b.d
        public void b(int i2, String str) {
            l lVar = new l();
            lVar.g(str);
            d.a.o0.b1.j.c.a("c13750", lVar, i2, HomePageTabFeedHeaderView.this.f16693h);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, l lVar) {
            d.a.o0.b1.j.c.b("c13750", lVar, i2, HomePageTabFeedHeaderView.this.f16693h);
        }
    }

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.f16694i = new c();
        this.j = new d();
        c();
    }

    public void c() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.f16690e = (TbPageContext) j.a(getContext());
    }

    public void d(int i2) {
        AutoBannerLayout autoBannerLayout = this.f16691f;
        if (autoBannerLayout != null) {
            autoBannerLayout.onChangeSkinType(this.f16690e, i2);
        }
        GridIconLayout gridIconLayout = this.f16692g;
        if (gridIconLayout != null) {
            gridIconLayout.onChangeSkinType(this.f16690e, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setData(d.a.o0.b1.j.h.c cVar) {
        List<l> list;
        if (cVar == null) {
            return;
        }
        setPadding(0, d.a.c.e.p.l.g(getContext(), R.dimen.M_H_X003), 0, 0);
        if (this.f16691f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f16691f = autoBannerLayout;
            autoBannerLayout.setMarqueenTime(3000L);
            this.f16691f.setOnCoverViewCallback(this.j);
            this.f16691f.setBannerHeight(d.a.c.e.p.l.g(getContext(), R.dimen.tbds343));
            addView(this.f16691f);
            this.f16691f.setIWindowChangedListener(new a());
        }
        this.f16691f.a(cVar.f55718e);
        if (this.f16692g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f16692g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f16694i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = d.a.c.e.p.l.g(this.f16690e.getPageActivity(), R.dimen.M_H_X003);
            addView(this.f16692g, layoutParams);
            int g2 = d.a.c.e.p.l.g(this.f16690e.getPageActivity(), R.dimen.M_H_X002);
            int g3 = d.a.c.e.p.l.g(this.f16690e.getPageActivity(), R.dimen.tbds30);
            k0 k0Var = cVar.f55719f;
            int size = (k0Var == null || (list = k0Var.f53845e) == null) ? 0 : list.size();
            if (size == 5 || size >= 9) {
                this.f16692g.setPadding(0, g2, 0, g2);
            } else if (size >= 4 && size < 9) {
                this.f16692g.setPadding(g3, g2, g3, g2);
            }
            this.f16692g.setIWindowChangedListener(new b());
            this.f16692g.setMaxItem(10);
        }
        this.f16692g.a(cVar.f55719f);
        this.f16692g.onChangeSkinType(this.f16690e, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTabCode(String str) {
        this.f16693h = str;
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16694i = new c();
        this.j = new d();
        c();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16694i = new c();
        this.j = new d();
        c();
    }
}
