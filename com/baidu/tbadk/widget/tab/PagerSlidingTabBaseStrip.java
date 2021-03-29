package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    public int A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public boolean M;
    public RectF N;
    public c O;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f14348e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f14349f;

    /* renamed from: g  reason: collision with root package name */
    public final d f14350g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f14351h;
    public LinearLayout i;
    public ViewPager j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public Paint p;
    public Paint q;
    public RectF r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f14352e;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14352e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f14352e = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = PagerSlidingTabBaseStrip.this;
            pagerSlidingTabBaseStrip.l = pagerSlidingTabBaseStrip.j.getCurrentItem();
            PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = PagerSlidingTabBaseStrip.this;
            pagerSlidingTabBaseStrip2.n = pagerSlidingTabBaseStrip2.l;
            PagerSlidingTabBaseStrip.this.y();
            PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = PagerSlidingTabBaseStrip.this;
            pagerSlidingTabBaseStrip3.x(pagerSlidingTabBaseStrip3.l, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f14354e;

        public b(int i) {
            this.f14354e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PagerSlidingTabBaseStrip.this.M) {
                return;
            }
            if (PagerSlidingTabBaseStrip.this.O != null) {
                PagerSlidingTabBaseStrip.this.O.a(view, this.f14354e);
            }
            if (PagerSlidingTabBaseStrip.this.j.getCurrentItem() != this.f14354e) {
                PagerSlidingTabBaseStrip.this.L = true;
                PagerSlidingTabBaseStrip.this.j.setCurrentItem(this.f14354e);
                PagerSlidingTabBaseStrip.this.y();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view, int i);
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.i.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip.x(pagerSlidingTabBaseStrip.j.getCurrentItem(), 0);
                PagerSlidingTabBaseStrip.this.m = 0.0f;
                PagerSlidingTabBaseStrip.this.L = false;
                PagerSlidingTabBaseStrip.this.M = false;
            } else if (i == 1) {
                PagerSlidingTabBaseStrip.this.M = true;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip2.o = pagerSlidingTabBaseStrip2.j.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip3.l = pagerSlidingTabBaseStrip3.o;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip4 = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip4.n = pagerSlidingTabBaseStrip4.l;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabBaseStrip.this.f14351h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (PagerSlidingTabBaseStrip.this.i.getChildCount() == 0) {
                return;
            }
            if (!PagerSlidingTabBaseStrip.this.L) {
                if (i == PagerSlidingTabBaseStrip.this.o) {
                    PagerSlidingTabBaseStrip.this.l = i;
                    PagerSlidingTabBaseStrip.this.n = i + 1;
                } else if (i > PagerSlidingTabBaseStrip.this.o) {
                    PagerSlidingTabBaseStrip.this.l = i;
                    PagerSlidingTabBaseStrip.this.n = i + 1;
                } else {
                    PagerSlidingTabBaseStrip.this.l = i + 1;
                    PagerSlidingTabBaseStrip.this.n = i;
                }
                if (f2 == 0.0f) {
                    PagerSlidingTabBaseStrip.this.o = i;
                    PagerSlidingTabBaseStrip.this.l = i;
                    PagerSlidingTabBaseStrip.this.n = i;
                }
                PagerSlidingTabBaseStrip.this.m = f2;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip.x(i, (int) (pagerSlidingTabBaseStrip.i.getChildAt(i).getWidth() * f2));
                PagerSlidingTabBaseStrip.this.y();
                PagerSlidingTabBaseStrip.this.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabBaseStrip.this.f14351h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabBaseStrip.this.f14351h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.L) {
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip.x(i, (int) (pagerSlidingTabBaseStrip.m * PagerSlidingTabBaseStrip.this.i.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.o = i;
                PagerSlidingTabBaseStrip.this.l = i;
                PagerSlidingTabBaseStrip.this.n = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }

        public /* synthetic */ d(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip, a aVar) {
            this();
        }
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.k == 0) {
            return;
        }
        View childAt = this.i.getChildAt(this.l);
        float left = childAt.getLeft() + this.B;
        float right = childAt.getRight() - this.B;
        if (this.m > 0.0f) {
            int i = this.l;
            int i2 = this.n;
            if (i != i2 && i2 <= this.k - 1 && i2 >= 0) {
                View childAt2 = this.i.getChildAt(i2);
                left = t(left, childAt2.getLeft() + this.B, this.m);
                right = u(right, childAt2.getRight() - this.B, this.m);
            }
        }
        int height = getHeight();
        RectF rectF = this.N;
        if (rectF == null) {
            int i3 = this.A;
            this.N = new RectF(left, (height - this.z) - i3, right, height - i3);
        } else {
            int i4 = this.A;
            rectF.set(left, (height - this.z) - i4, right, height - i4);
        }
        canvas.drawRoundRect(this.N, 16.0f, 16.0f, this.p);
        if (this.s) {
            View childAt3 = this.i.getChildAt(this.t);
            int right2 = (childAt3.getRight() - this.I) - this.G;
            int top = childAt3.getTop() + this.H;
            int i5 = this.G;
            this.r.set(right2, top, right2 + i5, top + i5);
            canvas.drawOval(this.r, this.q);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f14352e;
        this.l = i;
        this.n = i;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14352e = this.l;
        return savedState;
    }

    public final void q(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new b(i));
        this.i.addView(view, i, this.u ? this.f14349f : this.f14348e);
    }

    public final void r(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.D);
        textView.setSingleLine();
        q(i, textView);
    }

    public final float s(float f2) {
        float f3;
        float f4;
        if (f2 <= 0.1f) {
            f3 = this.E;
            f4 = (this.F - f3) / 0.1f;
        } else {
            f3 = this.F;
            f4 = (f3 - 1.0f) / (-0.9f);
            f2 -= 0.1f;
        }
        return f3 + (f4 * f2);
    }

    public void setConcernTabIndex(int i) {
        this.t = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.v = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.f14348e = layoutParams;
    }

    public void setIndicatorOffset(int i) {
        this.B = i;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f14351h = onPageChangeListener;
    }

    public void setOnTabItemClickListener(c cVar) {
        this.O = cVar;
    }

    public void setShowConcernRedTip(boolean z) {
        this.s = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.L = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.j = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.f14350g);
        w();
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.w = SkinManager.getColor(this.v);
            this.x = SkinManager.getColor(R.color.CAM_X0107);
        } else {
            this.w = SkinManager.getColor(R.color.CAM_X0101);
            this.x = SkinManager.getColor(R.color.CAM_X0101);
        }
        y();
        invalidate();
    }

    public final float t(float f2, float f3, float f4) {
        if (f3 <= f2) {
            return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
        }
        double d2 = f4;
        if (d2 <= 0.5d) {
            return f2;
        }
        if (d2 <= 0.85d) {
            return f2 + ((((f3 + this.C) - f2) * (f4 - 0.5f)) / 0.35f);
        }
        int i = this.C;
        return (f3 + i) - ((i * (f4 - 0.85f)) / 0.15f);
    }

    public final float u(float f2, float f3, float f4) {
        if (f3 > f2) {
            return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
        }
        double d2 = f4;
        if (d2 >= 0.5d) {
            return f2;
        }
        if (d2 >= 0.15d) {
            return f2 - ((((f2 - this.C) - f3) * (0.5f - f4)) / 0.35f);
        }
        int i = this.C;
        return (f3 - i) + ((i * (0.15f - f4)) / 0.15f);
    }

    public final float v(float f2) {
        if (f2 <= 0.1f) {
            return 1.0f;
        }
        if (f2 <= 0.9f) {
            return (((1.0f - this.F) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
        }
        float f3 = this.F;
        return f3 + (((f3 - this.E) / (-0.100000024f)) * (f2 - 0.9f));
    }

    public void w() {
        ViewPager viewPager = this.j;
        if (viewPager == null || viewPager.getAdapter() == null || this.j.getAdapter().getCount() == 0) {
            return;
        }
        this.i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i = 0; i < this.k; i++) {
            r(i, this.j.getAdapter().getPageTitle(i).toString());
        }
        y();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public final void x(int i, int i2) {
        if (this.k == 0) {
            return;
        }
        int left = this.i.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.y;
        }
        if (left != this.J) {
            this.J = left;
            scrollTo(left, 0);
        }
    }

    public final void y() {
        float v;
        float f2 = this.m;
        if (this.n < this.l) {
            f2 = 1.0f - f2;
        }
        int i = 0;
        while (i < this.k) {
            View childAt = this.i.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.K);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.l) {
                        v = s(f2);
                    } else {
                        v = i == this.n ? v(f2) : 1.0f;
                    }
                    textView.setScaleX(v);
                    textView.setScaleY(v);
                    if (v <= 1.0f) {
                        textView.setTextColor(this.x);
                    } else {
                        textView.setTextColor(this.w);
                    }
                    if (v <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14350g = new d(this, null);
        this.l = 0;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.u = false;
        int i2 = R.color.CAM_X0105;
        this.v = i2;
        this.w = SkinManager.getColor(i2);
        this.x = SkinManager.getColor(R.color.CAM_X0107);
        this.y = 52;
        this.z = 4;
        this.D = 17;
        this.J = 0;
        this.K = R.drawable.pager_sliding_view;
        this.L = false;
        this.M = false;
    }
}
