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
    public Context f13903e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13904f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f13905g;

    /* renamed from: h  reason: collision with root package name */
    public AlaBannerRecyclerAdapter f13906h;

    /* renamed from: i  reason: collision with root package name */
    public PagerSnapHelper f13907i;
    public int j;
    public long k;
    public boolean l;
    public d.a.n0.v.d.h.a.c m;
    public d.a.n0.v.d.h.a.b n;
    public d.a.n0.v.d.h.a.a o;
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
            AlaBannerAutoScrollView.this.f13905g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            AlaBannerAutoScrollView.this.r(0);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.n0.v.d.h.a.a {

        /* loaded from: classes4.dex */
        public class a extends AlaBannerViewHolder<d.a.n0.v.d.f.c.b> {

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f13911a;

            public a(c cVar, View view) {
                super(view);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                this.f13911a = (TbImageView) view.findViewById(R.id.cover);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i2) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i2, d.a.n0.v.d.f.c.b bVar) {
                if (bVar == null || this.f13911a == null || StringUtils.isNull(bVar.f61718f)) {
                    return;
                }
                this.f13911a.V(bVar.f61718f, 10, false);
            }
        }

        public c() {
        }

        @Override // d.a.n0.v.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            return new a(this, LayoutInflater.from(AlaBannerAutoScrollView.this.f13903e).inflate(R.layout.special_bar_recommend_activity, viewGroup, false));
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
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            int currentItem = AlaBannerAutoScrollView.this.getCurrentItem();
            int d2 = AlaBannerAutoScrollView.this.f13906h.d();
            AlaBannerAutoScrollView alaBannerAutoScrollView = AlaBannerAutoScrollView.this;
            if (d2 != 0) {
                currentItem %= d2;
            }
            alaBannerAutoScrollView.v(currentItem);
            if (AlaBannerAutoScrollView.this.m != null) {
                AlaBannerAutoScrollView.this.m.b(recyclerView, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (AlaBannerAutoScrollView.this.m != null) {
                AlaBannerAutoScrollView.this.m.a(recyclerView, i2, i3);
            }
        }
    }

    public AlaBannerAutoScrollView(Context context) {
        super(context);
        this.f13907i = new PagerSnapHelper();
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
        View findSnapView = this.f13907i.findSnapView(this.f13905g.getLayoutManager());
        if (findSnapView != null) {
            int position = this.f13905g.getLayoutManager().getPosition(findSnapView);
            int d2 = this.f13906h.d();
            if (position < d2) {
                int i2 = position + d2;
                this.f13905g.getLayoutManager().scrollToPosition(i2);
                return i2;
            } else if (position >= d2 * 2) {
                int i3 = position - d2;
                this.f13905g.getLayoutManager().scrollToPosition(i3);
                return i3;
            } else {
                return position;
            }
        }
        return -1;
    }

    private void setCurrentItem(int i2) {
        s(i2, false);
    }

    public void n(List<T> list, d.a.n0.v.d.h.a.a aVar) {
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
        this.f13906h.setData(list);
        this.f13906h.notifyDataSetChanged();
        t();
    }

    public final void o(Context context) {
        this.f13903e = context;
        LayoutInflater.from(context).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
        this.f13904f = (LinearLayout) findViewById(R.id.dotLayout);
        this.f13905g = (RecyclerView) findViewById(R.id.list_view);
        this.f13905g.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f13905g.setOnTouchListener(new a());
        AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(context, this.o, false);
        this.f13906h = alaBannerRecyclerAdapter;
        this.f13905g.setAdapter(alaBannerRecyclerAdapter);
        this.f13905g.addOnScrollListener(this.q);
        this.f13905g.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.f13907i.attachToRecyclerView(this.f13905g);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    public final void p(int i2) {
        if (this.f13904f.getChildCount() != this.j) {
            this.f13904f.removeAllViews();
            if (this.j == 1) {
                this.f13904f.setVisibility(8);
            } else {
                this.f13904f.setVisibility(0);
                int dimensionPixelSize = this.f13903e.getResources().getDimensionPixelSize(R.dimen.ds12);
                int dimensionPixelSize2 = this.f13903e.getResources().getDimensionPixelSize(R.dimen.ds20);
                for (int i3 = 0; i3 < this.j; i3++) {
                    View view = new View(this.f13903e);
                    view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    if (i3 != 0) {
                        layoutParams.leftMargin = dimensionPixelSize2;
                    }
                    this.f13904f.addView(view, layoutParams);
                }
            }
        }
        LinearLayout linearLayout = this.f13904f;
        if (linearLayout == null || linearLayout.getChildAt(0) == null) {
            return;
        }
        this.f13904f.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
    }

    public void q(int i2) {
        u();
        v(getCurrentItem());
        t();
    }

    public final void r(int i2) {
        RecyclerView recyclerView = this.f13905g;
        if (recyclerView == null) {
            return;
        }
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
    }

    public final void s(int i2, boolean z) {
        RecyclerView recyclerView = this.f13905g;
        if (recyclerView == null) {
            return;
        }
        if (z) {
            recyclerView.smoothScrollToPosition(i2);
        } else {
            r(i2);
        }
    }

    public void setAutoPlayDuation(long j) {
        this.k = j;
    }

    public void setOnBannerClickListener(d.a.n0.v.d.h.a.b bVar) {
        this.n = bVar;
        AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = this.f13906h;
        if (alaBannerRecyclerAdapter != null) {
            alaBannerRecyclerAdapter.h(bVar);
        }
    }

    public void setOnBannerScrollListener(d.a.n0.v.d.h.a.c cVar) {
        this.m = cVar;
    }

    public void setViewHolderAdapter(d.a.n0.v.d.h.a.a aVar) {
        this.f13906h.i(aVar);
    }

    public final void t() {
        postDelayed(this.p, 2000L);
    }

    public final void u() {
        removeCallbacks(this.p);
    }

    public final void v(int i2) {
        if (i2 >= this.f13904f.getChildCount()) {
            p(this.j);
            return;
        }
        for (int i3 = 0; i3 < this.f13904f.getChildCount(); i3++) {
            View childAt = this.f13904f.getChildAt(i3);
            if (childAt != null) {
                if (i3 == i2) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                } else {
                    SkinManager.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                }
            }
        }
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13907i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c();
        this.p = new d();
        this.q = new e();
        o(context);
    }

    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13907i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c();
        this.p = new d();
        this.q = new e();
        o(context);
    }
}
