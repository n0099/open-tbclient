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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
/* loaded from: classes4.dex */
public class HotRankView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17298e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f17299f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.c1.a.a f17300g;

    /* renamed from: h  reason: collision with root package name */
    public g f17301h;
    public View i;
    public d.b.h0.d0.g j;
    public h k;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (!j.z()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                HotRankView.this.f17299f.A(0L);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ((HotRanklistActivity) HotRankView.this.f17298e.getOrignalPage()).loadHotTopicRanklistData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013));
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
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
                hotRankView.l(true, l.g(hotRankView.f17298e.getPageActivity(), R.dimen.ds500));
                ((HotRanklistActivity) HotRankView.this.f17298e.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17299f = null;
        this.f17300g = null;
        this.f17301h = null;
        f(context);
    }

    public void c(boolean z) {
        BdTypeListView bdTypeListView = this.f17299f;
        if (bdTypeListView != null) {
            if (z) {
                bdTypeListView.z();
            } else {
                bdTypeListView.A(0L);
            }
        }
    }

    public void d() {
        d.b.h0.d0.g gVar = this.j;
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
        this.f17299f = bdTypeListView;
        bdTypeListView.setVerticalScrollBarEnabled(false);
        this.f17299f.setDividerHeight(0);
        this.f17299f.setSelector(17170445);
        d.b.c.a.f<?> a2 = d.b.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17298e = (TbPageContext) a2;
        }
        g gVar = new g(this.f17298e);
        this.f17301h = gVar;
        gVar.b(new a());
        this.f17299f.setPullRefresh(this.f17301h);
        this.i = BdListViewHelper.d(context, this.f17299f, BdListViewHelper.HeadType.HASTAB);
        this.f17299f.setOnScrollListener(new b());
        this.f17300g = new d.b.i0.c1.a.a((HotRanklistActivity) this.f17298e.getOrignalPage(), this.f17299f);
        addView(this.f17299f);
    }

    public boolean g() {
        d.b.h0.d0.g gVar = this.j;
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
        SkinManager.setBackgroundColor(this.f17299f, R.color.CAM_X0201);
        this.f17299f.getListAdapter().notifyDataSetChanged();
        d.b.h0.d0.g gVar = this.j;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.k;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
    }

    public void j(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = i2;
        this.i.setLayoutParams(layoutParams);
    }

    public void k(d.b.i0.c1.c.j jVar, String str) {
        if (this.f17300g == null) {
            return;
        }
        if (jVar == null) {
            jVar = new d.b.i0.c1.c.j();
        }
        this.f17299f.setVisibility(0);
        this.f17300g.b(jVar, str);
    }

    public void l(boolean z, int i) {
        if (g()) {
            return;
        }
        if (this.j == null) {
            if (i <= 0) {
                this.j = new d.b.h0.d0.g(getContext());
            } else {
                d.b.h0.d0.g gVar = new d.b.h0.d0.g(getContext(), i);
                this.j = gVar;
                gVar.h();
            }
            this.j.onChangeSkinType();
        }
        this.j.attachView(this, z);
        this.f17299f.setVisibility(8);
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
        this.f17299f.setVisibility(8);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17299f = null;
        this.f17300g = null;
        this.f17301h = null;
        f(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.f17299f = null;
        this.f17300g = null;
        this.f17301h = null;
        f(context);
    }
}
