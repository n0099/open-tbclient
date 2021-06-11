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
    public LinearLayout.LayoutParams f13383e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f13384f;

    /* renamed from: g  reason: collision with root package name */
    public final d f13385g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f13386h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f13387i;
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
        public int f13388e;

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
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f13388e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f13388e = parcel.readInt();
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
        public final /* synthetic */ int f13390e;

        public b(int i2) {
            this.f13390e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PagerSlidingTabBaseStrip.this.M) {
                return;
            }
            if (PagerSlidingTabBaseStrip.this.O != null) {
                PagerSlidingTabBaseStrip.this.O.a(view, this.f13390e);
            }
            if (PagerSlidingTabBaseStrip.this.j.getCurrentItem() != this.f13390e) {
                PagerSlidingTabBaseStrip.this.L = true;
                PagerSlidingTabBaseStrip.this.j.setCurrentItem(this.f13390e);
                PagerSlidingTabBaseStrip.this.y();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view, int i2);
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (PagerSlidingTabBaseStrip.this.f13387i.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip.x(pagerSlidingTabBaseStrip.j.getCurrentItem(), 0);
                PagerSlidingTabBaseStrip.this.m = 0.0f;
                PagerSlidingTabBaseStrip.this.L = false;
                PagerSlidingTabBaseStrip.this.M = false;
            } else if (i2 == 1) {
                PagerSlidingTabBaseStrip.this.M = true;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip2.o = pagerSlidingTabBaseStrip2.j.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip3.l = pagerSlidingTabBaseStrip3.o;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip4 = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip4.n = pagerSlidingTabBaseStrip4.l;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabBaseStrip.this.f13386h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (PagerSlidingTabBaseStrip.this.f13387i.getChildCount() == 0) {
                return;
            }
            if (!PagerSlidingTabBaseStrip.this.L) {
                if (i2 == PagerSlidingTabBaseStrip.this.o) {
                    PagerSlidingTabBaseStrip.this.l = i2;
                    PagerSlidingTabBaseStrip.this.n = i2 + 1;
                } else if (i2 > PagerSlidingTabBaseStrip.this.o) {
                    PagerSlidingTabBaseStrip.this.l = i2;
                    PagerSlidingTabBaseStrip.this.n = i2 + 1;
                } else {
                    PagerSlidingTabBaseStrip.this.l = i2 + 1;
                    PagerSlidingTabBaseStrip.this.n = i2;
                }
                if (f2 == 0.0f) {
                    PagerSlidingTabBaseStrip.this.o = i2;
                    PagerSlidingTabBaseStrip.this.l = i2;
                    PagerSlidingTabBaseStrip.this.n = i2;
                }
                PagerSlidingTabBaseStrip.this.m = f2;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip.x(i2, (int) (pagerSlidingTabBaseStrip.f13387i.getChildAt(i2).getWidth() * f2));
                PagerSlidingTabBaseStrip.this.y();
                PagerSlidingTabBaseStrip.this.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabBaseStrip.this.f13386h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabBaseStrip.this.f13386h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i2);
            }
            if (PagerSlidingTabBaseStrip.this.L) {
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = PagerSlidingTabBaseStrip.this;
                pagerSlidingTabBaseStrip.x(i2, (int) (pagerSlidingTabBaseStrip.m * PagerSlidingTabBaseStrip.this.f13387i.getChildAt(i2).getWidth()));
                PagerSlidingTabBaseStrip.this.o = i2;
                PagerSlidingTabBaseStrip.this.l = i2;
                PagerSlidingTabBaseStrip.this.n = i2;
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
        View childAt = this.f13387i.getChildAt(this.l);
        float left = childAt.getLeft() + this.B;
        float right = childAt.getRight() - this.B;
        if (this.m > 0.0f) {
            int i2 = this.l;
            int i3 = this.n;
            if (i2 != i3 && i3 <= this.k - 1 && i3 >= 0) {
                View childAt2 = this.f13387i.getChildAt(i3);
                left = t(left, childAt2.getLeft() + this.B, this.m);
                right = u(right, childAt2.getRight() - this.B, this.m);
            }
        }
        int height = getHeight();
        RectF rectF = this.N;
        if (rectF == null) {
            int i4 = this.A;
            this.N = new RectF(left, (height - this.z) - i4, right, height - i4);
        } else {
            int i5 = this.A;
            rectF.set(left, (height - this.z) - i5, right, height - i5);
        }
        canvas.drawRoundRect(this.N, 16.0f, 16.0f, this.p);
        if (this.s) {
            View childAt3 = this.f13387i.getChildAt(this.t);
            int right2 = (childAt3.getRight() - this.I) - this.G;
            int top = childAt3.getTop() + this.H;
            int i6 = this.G;
            this.r.set(right2, top, right2 + i6, top + i6);
            canvas.drawOval(this.r, this.q);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i2 = savedState.f13388e;
        this.l = i2;
        this.n = i2;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13388e = this.l;
        return savedState;
    }

    public final void q(int i2, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new b(i2));
        this.f13387i.addView(view, i2, this.u ? this.f13384f : this.f13383e);
    }

    public final void r(int i2, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.D);
        textView.setSingleLine();
        q(i2, textView);
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

    public void setConcernTabIndex(int i2) {
        this.t = i2;
    }

    public void setDefaultSelectorColorResourceId(int i2) {
        this.v = i2;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.f13383e = layoutParams;
    }

    public void setIndicatorOffset(int i2) {
        this.B = i2;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f13386h = onPageChangeListener;
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
        viewPager.setOnPageChangeListener(this.f13385g);
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
        int i2 = this.C;
        return (f3 + i2) - ((i2 * (f4 - 0.85f)) / 0.15f);
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
        int i2 = this.C;
        return (f3 - i2) + ((i2 * (0.15f - f4)) / 0.15f);
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
        this.f13387i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i2 = 0; i2 < this.k; i2++) {
            r(i2, this.j.getAdapter().getPageTitle(i2).toString());
        }
        y();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public final void x(int i2, int i3) {
        if (this.k == 0) {
            return;
        }
        int left = this.f13387i.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
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
        int i2 = 0;
        while (i2 < this.k) {
            View childAt = this.f13387i.getChildAt(i2);
            if (childAt != null) {
                childAt.setBackgroundResource(this.K);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i2 == this.l) {
                        v = s(f2);
                    } else {
                        v = i2 == this.n ? v(f2) : 1.0f;
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
            i2++;
        }
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13385g = new d(this, null);
        this.l = 0;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.u = false;
        int i3 = R.color.CAM_X0105;
        this.v = i3;
        this.w = SkinManager.getColor(i3);
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
