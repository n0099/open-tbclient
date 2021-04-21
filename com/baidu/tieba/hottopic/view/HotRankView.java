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
import d.b.i0.d0.h;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
/* loaded from: classes4.dex */
public class HotRankView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17306e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f17307f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.c1.a.a f17308g;

    /* renamed from: h  reason: collision with root package name */
    public g f17309h;
    public View i;
    public d.b.i0.d0.g j;
    public h k;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (!j.z()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                HotRankView.this.f17307f.A(0L);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ((HotRanklistActivity) HotRankView.this.f17306e.getOrignalPage()).loadHotTopicRanklistData();
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
                hotRankView.l(true, l.g(hotRankView.f17306e.getPageActivity(), R.dimen.ds500));
                ((HotRanklistActivity) HotRankView.this.f17306e.getOrignalPage()).loadHotTopicRanklistData();
            }
        }
    }

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17307f = null;
        this.f17308g = null;
        this.f17309h = null;
        f(context);
    }

    public void c(boolean z) {
        BdTypeListView bdTypeListView = this.f17307f;
        if (bdTypeListView != null) {
            if (z) {
                bdTypeListView.z();
            } else {
                bdTypeListView.A(0L);
            }
        }
    }

    public void d() {
        d.b.i0.d0.g gVar = this.j;
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
        this.f17307f = bdTypeListView;
        bdTypeListView.setVerticalScrollBarEnabled(false);
        this.f17307f.setDividerHeight(0);
        this.f17307f.setSelector(17170445);
        d.b.c.a.f<?> a2 = d.b.c.a.j.a(context);
        if (a2 instanceof TbPageContext) {
            this.f17306e = (TbPageContext) a2;
        }
        g gVar = new g(this.f17306e);
        this.f17309h = gVar;
        gVar.b(new a());
        this.f17307f.setPullRefresh(this.f17309h);
        this.i = BdListViewHelper.d(context, this.f17307f, BdListViewHelper.HeadType.HASTAB);
        this.f17307f.setOnScrollListener(new b());
        this.f17308g = new d.b.j0.c1.a.a((HotRanklistActivity) this.f17306e.getOrignalPage(), this.f17307f);
        addView(this.f17307f);
    }

    public boolean g() {
        d.b.i0.d0.g gVar = this.j;
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
        SkinManager.setBackgroundColor(this.f17307f, R.color.CAM_X0201);
        this.f17307f.getListAdapter().notifyDataSetChanged();
        d.b.i0.d0.g gVar = this.j;
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

    public void k(d.b.j0.c1.c.j jVar, String str) {
        if (this.f17308g == null) {
            return;
        }
        if (jVar == null) {
            jVar = new d.b.j0.c1.c.j();
        }
        this.f17307f.setVisibility(0);
        this.f17308g.b(jVar, str);
    }

    public void l(boolean z, int i) {
        if (g()) {
            return;
        }
        if (this.j == null) {
            if (i <= 0) {
                this.j = new d.b.i0.d0.g(getContext());
            } else {
                d.b.i0.d0.g gVar = new d.b.i0.d0.g(getContext(), i);
                this.j = gVar;
                gVar.h();
            }
            this.j.onChangeSkinType();
        }
        this.j.attachView(this, z);
        this.f17307f.setVisibility(8);
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
        this.f17307f.setVisibility(8);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17307f = null;
        this.f17308g = null;
        this.f17309h = null;
        f(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.f17307f = null;
        this.f17308g = null;
        this.f17309h = null;
        f(context);
    }
}
