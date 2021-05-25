package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
/* loaded from: classes4.dex */
public class HotRankView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f16829e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f16830f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.d1.a.a f16831g;

    /* renamed from: h  reason: collision with root package name */
    public g f16832h;

    /* renamed from: i  reason: collision with root package name */
    public View f16833i;
    public d.a.m0.d0.g j;
    public h k;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (!j.z()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                HotRankView.this.f16830f.A(0L);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ((HotRanklistActivity) HotRankView.this.f16829e.getOrignalPage()).loadHotTopicRanklistData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013));
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                HotRankView.this.e();
                HotRankView hotRankView = HotRankView.this;
                hotRankView.l(true, l.g(hotRankView.f16829e.getPageActivity(), R.dimen.ds500));
                ((HotRanklistActivity) HotRankView.this.f16829e.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    public HotRankView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16830f = null;
        this.f16831g = null;
        this.f16832h = null;
        f(context);
    }

    public void c(boolean z) {
        BdTypeListView bdTypeListView = this.f16830f;
        if (bdTypeListView != null) {
            if (z) {
                bdTypeListView.z();
            } else {
                bdTypeListView.A(0L);
            }
        }
    }

    public void d() {
        d.a.m0.d0.g gVar = this.j;
        if (gVar != null) {
            gVar.dettachView(this);
            this.j = null;
        }
    }

    public void e() {
        h hVar = this.k;
        if (hVar != null) {
            hVar.dettachView(this);
            this.k = null;
        }
    }

    public final void f(Context context) {
        BdTypeListView bdTypeListView = new BdTypeListView(context);
        this.f16830f = bdTypeListView;
        bdTypeListView.setVerticalScrollBarEnabled(false);
        this.f16830f.setDividerHeight(0);
        this.f16830f.setSelector(17170445);
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f16829e = (TbPageContext) a2;
        }
        g gVar = new g(this.f16829e);
        this.f16832h = gVar;
        gVar.a(new a());
        this.f16830f.setPullRefresh(this.f16832h);
        this.f16833i = BdListViewHelper.d(context, this.f16830f, BdListViewHelper.HeadType.HASTAB);
        this.f16830f.setOnScrollListener(new b());
        this.f16831g = new d.a.n0.d1.a.a((HotRanklistActivity) this.f16829e.getOrignalPage(), this.f16830f);
        addView(this.f16830f);
    }

    public boolean g() {
        d.a.m0.d0.g gVar = this.j;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public boolean h() {
        h hVar = this.k;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void i() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f16830f, R.color.CAM_X0201);
        this.f16830f.getListAdapter().notifyDataSetChanged();
        d.a.m0.d0.g gVar = this.j;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.k;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    public void j(View view, int i2, int i3, int i4, int i5) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.f16833i.getLayoutParams();
        layoutParams.height = i3;
        this.f16833i.setLayoutParams(layoutParams);
    }

    public void k(d.a.n0.d1.c.j jVar, String str) {
        if (this.f16831g == null) {
            return;
        }
        if (jVar == null) {
            jVar = new d.a.n0.d1.c.j();
        }
        this.f16830f.setVisibility(0);
        this.f16831g.b(jVar, str);
    }

    public void l(boolean z, int i2) {
        if (g()) {
            return;
        }
        if (this.j == null) {
            if (i2 <= 0) {
                this.j = new d.a.m0.d0.g(getContext());
            } else {
                d.a.m0.d0.g gVar = new d.a.m0.d0.g(getContext(), i2);
                this.j = gVar;
                gVar.h();
            }
            this.j.onChangeSkinType();
        }
        this.j.attachView(this, z);
        this.f16830f.setVisibility(8);
    }

    public void m(String str, boolean z) {
        if (h()) {
            return;
        }
        if (this.k == null) {
            this.k = new h(getContext(), new c());
        }
        this.k.j(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.k.attachView(this, z);
        this.k.o();
        this.f16830f.setVisibility(8);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16830f = null;
        this.f16831g = null;
        this.f16832h = null;
        f(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.f16830f = null;
        this.f16831g = null;
        this.f16832h = null;
        f(context);
    }
}
