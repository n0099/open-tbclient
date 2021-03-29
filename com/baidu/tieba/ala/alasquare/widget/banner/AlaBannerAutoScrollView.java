package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f14940e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14941f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f14942g;

    /* renamed from: h  reason: collision with root package name */
    public AlaBannerRecyclerAdapter f14943h;
    public PagerSnapHelper i;
    public int j;
    public long k;
    public boolean l;
    public d.b.i0.t.d.h.a.c m;
    public d.b.i0.t.d.h.a.b n;
    public d.b.i0.t.d.h.a.a o;
    public Runnable p;
    public RecyclerView.OnScrollListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                AlaBannerAutoScrollView.this.u();
                return false;
            } else if (action == 1) {
                AlaBannerAutoScrollView.this.t();
                return false;
            } else if (action != 2) {
                AlaBannerAutoScrollView.this.t();
                return false;
            } else {
                AlaBannerAutoScrollView.this.u();
                return false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            AlaBannerAutoScrollView.this.f14942g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AlaBannerAutoScrollView.this.r(0);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.i0.t.d.h.a.a {

        /* loaded from: classes4.dex */
        public class a extends AlaBannerViewHolder<d.b.i0.t.d.f.c.b> {

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f14947a;

            public a(c cVar, View view) {
                super(view);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                this.f14947a = (TbImageView) view.findViewById(R.id.cover);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, d.b.i0.t.d.f.c.b bVar) {
                if (bVar == null || this.f14947a == null || StringUtils.isNull(bVar.f60533f)) {
                    return;
                }
                this.f14947a.W(bVar.f60533f, 10, false);
            }
        }

        public c() {
        }

        @Override // d.b.i0.t.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            return new a(this, LayoutInflater.from(AlaBannerAutoScrollView.this.f14940e).inflate(R.layout.special_bar_recommend_activity, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int currentItem;
            if (AlaBannerAutoScrollView.this.l && (currentItem = AlaBannerAutoScrollView.this.getCurrentItem()) != -1) {
                AlaBannerAutoScrollView.this.s(currentItem + 1, true);
            }
            AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
            alaBannerAutoScrollView.postDelayed(alaBannerAutoScrollView.p, AlaBannerAutoScrollView.this.k);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
            int m = AlaBannerAutoScrollView.this.f14943h.m();
            AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
            if (m != 0) {
                currentItem %= m;
            }
            alaBannerAutoScrollView.v(currentItem);
            if (AlaBannerAutoScrollView.this.m != null) {
                AlaBannerAutoScrollView.this.m.b(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (AlaBannerAutoScrollView.this.m != null) {
                AlaBannerAutoScrollView.this.m.a(recyclerView, i, i2);
            }
        }
    }

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c();
        this.p = new d();
        this.q = new e();
        o(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        View findSnapView = this.i.findSnapView(this.f14942g.getLayoutManager());
        if (findSnapView != null) {
            int position = this.f14942g.getLayoutManager().getPosition(findSnapView);
            int m = this.f14943h.m();
            if (position < m) {
                int i = position + m;
                this.f14942g.getLayoutManager().scrollToPosition(i);
                return i;
            } else if (position >= m * 2) {
                int i2 = position - m;
                this.f14942g.getLayoutManager().scrollToPosition(i2);
                return i2;
            } else {
                return position;
            }
        }
        return -1;
    }

    private void setCurrentItem(int i) {
        s(i, false);
    }

    public void n(List<T> list, d.b.i0.t.d.h.a.a aVar) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        u();
        if (this.j != ListUtils.getCount(list)) {
            int count = ListUtils.getCount(list);
            this.j = count;
            if (count == 1) {
                this.l = false;
            } else {
                this.l = true;
            }
            p(this.j);
        }
        this.f14943h.setData(list);
        this.f14943h.notifyDataSetChanged();
        t();
    }

    public final void o(Context context) {
        this.f14940e = context;
        LayoutInflater.from(context).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.f14941f = (LinearLayout) findViewById(R.id.dotLayout);
        this.f14942g = (RecyclerView) findViewById(R.id.list_view);
        this.f14942g.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f14942g.setOnTouchListener(new a());
        AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(context, this.o, false);
        this.f14943h = alaBannerRecyclerAdapter;
        this.f14942g.setAdapter(alaBannerRecyclerAdapter);
        this.f14942g.addOnScrollListener(this.q);
        this.f14942g.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.i.attachToRecyclerView(this.f14942g);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    public final void p(int i) {
        if (this.f14941f.getChildCount() != this.j) {
            this.f14941f.removeAllViews();
            if (this.j == 1) {
                this.f14941f.setVisibility(8);
            } else {
                this.f14941f.setVisibility(0);
                int dimensionPixelSize = this.f14940e.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.f14940e.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i2 = 0; i2 < this.j; i2++) {
                    View view = new View(this.f14940e);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i2 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.f14941f.addView(view, layoutParams);
                }
            }
        }
        LinearLayout linearLayout = this.f14941f;
        if (linearLayout == null || linearLayout.getChildAt(0) == null) {
            return;
        }
        this.f14941f.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
    }

    public void q(int i) {
        u();
        v(getCurrentItem());
        t();
    }

    public final void r(int i) {
        RecyclerView recyclerView = this.f14942g;
        if (recyclerView == null) {
            return;
        }
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
    }

    public final void s(int i, boolean z) {
        RecyclerView recyclerView = this.f14942g;
        if (recyclerView == null) {
            return;
        }
        if (z) {
            recyclerView.smoothScrollToPosition(i);
        } else {
            r(i);
        }
    }

    public void setAutoPlayDuation(long j) {
        this.k = j;
    }

    public void setOnBannerClickListener(d.b.i0.t.d.h.a.b bVar) {
        this.n = bVar;
        AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = this.f14943h;
        if (alaBannerRecyclerAdapter != null) {
            alaBannerRecyclerAdapter.q(bVar);
        }
    }

    public void setOnBannerScrollListener(d.b.i0.t.d.h.a.c cVar) {
        this.m = cVar;
    }

    public void setViewHolderAdapter(d.b.i0.t.d.h.a.a aVar) {
        this.f14943h.r(aVar);
    }

    public final void t() {
        postDelayed(this.p, 2000L);
    }

    public final void u() {
        removeCallbacks(this.p);
    }

    public final void v(int i) {
        if (i >= this.f14941f.getChildCount()) {
            p(this.j);
            return;
        }
        for (int i2 = 0; i2 < this.f14941f.getChildCount(); i2++) {
            View childAt = this.f14941f.getChildAt(i2);
            if (childAt != null) {
                if (i2 == i) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    SkinManager.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c();
        this.p = new d();
        this.q = new e();
        o(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c();
        this.p = new d();
        this.q = new e();
        o(context);
    }
}
