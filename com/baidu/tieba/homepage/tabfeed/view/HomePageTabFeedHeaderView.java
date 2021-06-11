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
import d.a.m0.m.f;
import d.a.m0.r.q.k0;
import d.a.m0.r.q.l;
import java.util.List;
/* loaded from: classes4.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16608e;

    /* renamed from: f  reason: collision with root package name */
    public AutoBannerLayout f16609f;

    /* renamed from: g  reason: collision with root package name */
    public GridIconLayout f16610g;

    /* renamed from: h  reason: collision with root package name */
    public String f16611h;

    /* renamed from: i  reason: collision with root package name */
    public f f16612i;
    public d.a.m0.r.w.b.d<l> j;

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.m.c {
        public a() {
        }

        @Override // d.a.m0.m.c
        public void a(View view, boolean z, Object obj) {
            if (!z || HomePageTabFeedHeaderView.this.f16609f == null) {
                return;
            }
            HomePageTabFeedHeaderView.this.f16609f.d();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.m0.m.c {
        public b() {
        }

        @Override // d.a.m0.m.c
        public void a(View view, boolean z, Object obj) {
            if (z) {
                d.a.n0.b1.j.c.c("c13751", HomePageTabFeedHeaderView.this.f16611h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f<l> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, l lVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, l lVar, int i2, long j) {
            d.a.n0.b1.j.c.a("c13751", lVar, i2 + 1, HomePageTabFeedHeaderView.this.f16611h);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.m0.r.w.b.d<l> {
        public d() {
        }

        @Override // d.a.m0.r.w.b.d
        public void b(int i2, String str) {
            l lVar = new l();
            lVar.g(str);
            d.a.n0.b1.j.c.a("c13750", lVar, i2, HomePageTabFeedHeaderView.this.f16611h);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, l lVar) {
            d.a.n0.b1.j.c.b("c13750", lVar, i2, HomePageTabFeedHeaderView.this.f16611h);
        }
    }

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.f16612i = new c();
        this.j = new d();
        c();
    }

    public void c() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.f16608e = (TbPageContext) j.a(getContext());
    }

    public void d(int i2) {
        AutoBannerLayout autoBannerLayout = this.f16609f;
        if (autoBannerLayout != null) {
            autoBannerLayout.onChangeSkinType(this.f16608e, i2);
        }
        GridIconLayout gridIconLayout = this.f16610g;
        if (gridIconLayout != null) {
            gridIconLayout.onChangeSkinType(this.f16608e, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setData(d.a.n0.b1.j.h.c cVar) {
        List<l> list;
        if (cVar == null) {
            return;
        }
        setPadding(0, d.a.c.e.p.l.g(getContext(), R.dimen.M_H_X003), 0, 0);
        if (this.f16609f == null) {
            AutoBannerLayout autoBannerLayout = new AutoBannerLayout(getContext());
            this.f16609f = autoBannerLayout;
            autoBannerLayout.setMarqueenTime(3000L);
            this.f16609f.setOnCoverViewCallback(this.j);
            this.f16609f.setBannerHeight(d.a.c.e.p.l.g(getContext(), R.dimen.tbds343));
            addView(this.f16609f);
            this.f16609f.setIWindowChangedListener(new a());
        }
        this.f16609f.a(cVar.f55593e);
        if (this.f16610g == null) {
            GridIconLayout gridIconLayout = new GridIconLayout(getContext());
            this.f16610g = gridIconLayout;
            gridIconLayout.setOnItemCoverListener(this.f16612i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = d.a.c.e.p.l.g(this.f16608e.getPageActivity(), R.dimen.M_H_X003);
            addView(this.f16610g, layoutParams);
            int g2 = d.a.c.e.p.l.g(this.f16608e.getPageActivity(), R.dimen.M_H_X002);
            int g3 = d.a.c.e.p.l.g(this.f16608e.getPageActivity(), R.dimen.tbds30);
            k0 k0Var = cVar.f55594f;
            int size = (k0Var == null || (list = k0Var.f53738e) == null) ? 0 : list.size();
            if (size == 5 || size >= 9) {
                this.f16610g.setPadding(0, g2, 0, g2);
            } else if (size >= 4 && size < 9) {
                this.f16610g.setPadding(g3, g2, g3, g2);
            }
            this.f16610g.setIWindowChangedListener(new b());
            this.f16610g.setMaxItem(10);
        }
        this.f16610g.a(cVar.f55594f);
        this.f16610g.onChangeSkinType(this.f16608e, TbadkCoreApplication.getInst().getSkinType());
    }

    public void setTabCode(String str) {
        this.f16611h = str;
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16612i = new c();
        this.j = new d();
        c();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16612i = new c();
        this.j = new d();
        c();
    }
}
