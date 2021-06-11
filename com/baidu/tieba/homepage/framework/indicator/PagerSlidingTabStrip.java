package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import d.a.c.e.p.l;
import java.util.Locale;
/* loaded from: classes4.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public float M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public boolean U;
    public Locale V;
    public RectF W;
    public int a0;
    public c b0;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f16328e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f16329f;

    /* renamed from: g  reason: collision with root package name */
    public final d f16330g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f16331h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f16332i;
    public ViewPager j;
    public int k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public Paint q;
    public Paint r;
    public RectF s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f16333e;

        /* loaded from: classes4.dex */
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
            parcel.writeInt(this.f16333e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f16333e = parcel.readInt();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip.m = pagerSlidingTabStrip.j.getCurrentItem();
            PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip2.o = pagerSlidingTabStrip2.m;
            PagerSlidingTabStrip.this.F();
            PagerSlidingTabStrip pagerSlidingTabStrip3 = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip3.E(pagerSlidingTabStrip3.m, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16335e;

        public b(int i2) {
            this.f16335e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PagerSlidingTabStrip.this.U) {
                return;
            }
            if (PagerSlidingTabStrip.this.b0 != null) {
                PagerSlidingTabStrip.this.b0.a(view, this.f16335e);
            }
            if (this.f16335e == 1 || !FullBrowseHelper.checkIsFullBrowseMode()) {
                int currentItem = PagerSlidingTabStrip.this.j.getCurrentItem();
                int i2 = this.f16335e;
                if (currentItem != i2 || i2 != 0 || !TbadkCoreApplication.isLogin() || !d.a.m0.b.d.h()) {
                    if (PagerSlidingTabStrip.this.j.getCurrentItem() == this.f16335e) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_locate", this.f16335e + 1).param("obj_type", "1"));
                    PagerSlidingTabStrip.this.T = true;
                    if (PagerSlidingTabStrip.this.j.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.j.getAdapter()).I(this.f16335e);
                    }
                    PagerSlidingTabStrip.this.j.setCurrentItem(this.f16335e);
                    PagerSlidingTabStrip.this.F();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, int i2);
    }

    /* loaded from: classes4.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (PagerSlidingTabStrip.this.f16332i.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.E(pagerSlidingTabStrip.j.getCurrentItem(), 0);
                PagerSlidingTabStrip.this.n = 0.0f;
                PagerSlidingTabStrip.this.T = false;
                PagerSlidingTabStrip.this.U = false;
            } else if (i2 == 1) {
                PagerSlidingTabStrip.this.U = true;
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.p = pagerSlidingTabStrip2.j.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip3.m = pagerSlidingTabStrip3.p;
                PagerSlidingTabStrip pagerSlidingTabStrip4 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip4.o = pagerSlidingTabStrip4.m;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f16331h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
            HomePageStatic.f16182a = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (PagerSlidingTabStrip.this.f16332i.getChildCount() == 0) {
                return;
            }
            if (!PagerSlidingTabStrip.this.T) {
                if (i2 == PagerSlidingTabStrip.this.p) {
                    PagerSlidingTabStrip.this.m = i2;
                    PagerSlidingTabStrip.this.o = i2 + 1;
                } else if (i2 > PagerSlidingTabStrip.this.p) {
                    PagerSlidingTabStrip.this.m = i2;
                    PagerSlidingTabStrip.this.o = i2 + 1;
                } else {
                    PagerSlidingTabStrip.this.m = i2 + 1;
                    PagerSlidingTabStrip.this.o = i2;
                }
                if (f2 == 0.0f) {
                    PagerSlidingTabStrip.this.p = i2;
                    PagerSlidingTabStrip.this.m = i2;
                    PagerSlidingTabStrip.this.o = i2;
                }
                PagerSlidingTabStrip.this.n = f2;
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.E(i2, (int) (pagerSlidingTabStrip.f16332i.getChildAt(i2).getWidth() * f2));
            }
            PagerSlidingTabStrip.this.F();
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f16331h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f16331h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i2);
            }
            if (PagerSlidingTabStrip.this.T) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.E(i2, (int) (pagerSlidingTabStrip.n * PagerSlidingTabStrip.this.f16332i.getChildAt(i2).getWidth()));
                PagerSlidingTabStrip.this.p = i2;
                PagerSlidingTabStrip.this.m = i2;
                PagerSlidingTabStrip.this.o = i2;
            }
            PagerSlidingTabStrip.this.invalidate();
        }

        public /* synthetic */ d(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
            this();
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public boolean A() {
        return this.t;
    }

    public boolean B() {
        return this.u;
    }

    public void C() {
        ViewPager viewPager = this.j;
        if (viewPager == null || viewPager.getAdapter() == null || this.j.getAdapter().getCount() == 0) {
            return;
        }
        this.f16332i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i2 = 0; i2 < this.k; i2++) {
            r(i2, this.j.getAdapter().getPageTitle(i2).toString());
        }
        F();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void D() {
        if (this.l != TbadkCoreApplication.getInst().getSkinType()) {
            this.l = TbadkCoreApplication.getInst().getSkinType();
            this.A = SkinManager.getColor(this.x);
            this.B = SkinManager.getColor(this.y);
            this.q.setColor(SkinManager.getColor(this.z));
            this.r.setColor(SkinManager.getColor(R.color.CAM_X0301));
            F();
            invalidate();
        }
    }

    public final void E(int i2, int i3) {
        if (this.k == 0) {
            return;
        }
        int left = this.f16332i.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.C;
        }
        if (left != this.R) {
            this.R = left;
            scrollTo(left, 0);
        }
    }

    public final void F() {
        float x;
        float f2 = this.n;
        if (this.o < this.m) {
            f2 = 1.0f - f2;
        }
        int i2 = 0;
        while (i2 < this.k) {
            View childAt = this.f16332i.getChildAt(i2);
            if (childAt != null) {
                childAt.setBackgroundResource(this.S);
                TextView textView = null;
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    textView = (TextView) linearLayout.getChildAt(0);
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ((ImageView) linearLayout.getChildAt(1)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_home_unfold16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                    }
                }
                if (textView != null) {
                    if (i2 == this.m) {
                        x = s(f2);
                    } else {
                        x = i2 == this.o ? x(f2) : 1.0f;
                    }
                    textView.setScaleX(x);
                    textView.setScaleY(x);
                    int i3 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                    if (i3 >= 0) {
                        if (i2 == this.o) {
                            textView.setTextColor(this.A);
                        } else {
                            textView.setTextColor(this.B);
                        }
                    } else if (i2 == this.m) {
                        textView.setTextColor(this.A);
                    } else {
                        textView.setTextColor(this.B);
                    }
                    if (i3 >= 0) {
                        if (i2 == this.o) {
                            d.a.m0.r.u.c.d(textView).x(R.string.F_X02);
                        } else {
                            d.a.m0.r.u.c.d(textView).x(R.string.F_X01);
                        }
                    } else if (i2 == this.m) {
                        d.a.m0.r.u.c.d(textView).x(R.string.F_X02);
                    } else {
                        d.a.m0.r.u.c.d(textView).x(R.string.F_X01);
                    }
                }
            }
            i2++;
        }
    }

    public int getCurrentTabIndex() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        View childAt;
        super.onDraw(canvas);
        if (isInEditMode() || this.k == 0) {
            return;
        }
        View childAt2 = this.f16332i.getChildAt(this.m);
        float left = childAt2.getLeft() + this.F;
        float right = childAt2.getRight() - this.F;
        if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
            float left2 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
            right = v(left2, childAt2);
            left = u(left2, childAt2);
        }
        if (this.n > 0.0f) {
            int i2 = this.m;
            int i3 = this.o;
            if (i2 != i3 && i3 <= this.k - 1 && i3 >= 0) {
                View childAt3 = this.f16332i.getChildAt(i3);
                float left3 = childAt3.getLeft() + this.F;
                float right2 = childAt3.getRight() - this.F;
                if ((childAt3 instanceof LinearLayout) && (((LinearLayout) childAt3).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt3.getLeft() + childAt3.getRight()) / 2.0f;
                    right2 = v(left4, childAt3);
                    left3 = u(left4, childAt3);
                }
                left = t(left, left3, this.n);
                right = w(right, right2, this.n);
            }
        }
        int height = getHeight();
        RectF rectF = this.W;
        if (rectF == null) {
            int i4 = this.E;
            this.W = new RectF(left, (height - this.D) - i4, right, height - i4);
        } else {
            int i5 = this.E;
            rectF.set(left, (height - this.D) - i5, right, height - i5);
        }
        RectF rectF2 = this.W;
        int i6 = this.D;
        canvas.drawRoundRect(rectF2, i6 * 0.5f, i6 * 0.5f, this.q);
        if (!this.u || (childAt = this.f16332i.getChildAt(this.v)) == null) {
            return;
        }
        int right3 = (childAt.getRight() - this.Q) - this.O;
        int top = childAt.getTop() + this.P;
        int i7 = this.O;
        this.s.set(right3, top, right3 + i7, top + i7);
        canvas.drawOval(this.s, this.r);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i2 = savedState.f16333e;
        this.m = i2;
        this.o = i2;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16333e = this.m;
        return savedState;
    }

    public final void q(int i2, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new b(i2));
        if (i2 == 0 && (view instanceof LinearLayout) && d.a.m0.b.d.h()) {
            this.f16332i.addView(view, i2, this.f16328e);
        } else {
            this.f16332i.addView(view, i2, this.w ? this.f16329f : this.f16328e);
        }
    }

    public final void r(int i2, String str) {
        String string;
        if (d.a.m0.b.d.h() && i2 == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && d.a.m0.r.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.J);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_home_unfold16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.a0;
            linearLayout.setGravity(16);
            q(i2, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i2 == 0) {
            if (d.a.m0.b.d.h() && TbadkCoreApplication.isLogin() && d.a.m0.r.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.J);
        eMTextView.setSingleLine();
        eMTextView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
        eMTextView.setGravity(17);
        eMTextView.setText(str);
        q(i2, eMTextView);
    }

    public final float s(float f2) {
        float f3;
        float f4;
        if (f2 <= 0.1f) {
            f3 = this.M;
            f4 = (this.N - f3) / 0.1f;
        } else {
            f3 = this.N;
            f4 = (f3 - 1.0f) / (-0.9f);
            f2 -= 0.1f;
        }
        return f3 + (f4 * f2);
    }

    public void setConcernTabIndex(int i2) {
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.f16329f = layoutParams;
    }

    public void setHotTopicIndex(int i2) {
        this.v = i2;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f16331h = onPageChangeListener;
    }

    public void setOnTabItemClickListener(c cVar) {
        this.b0 = cVar;
    }

    public void setShowConcernRedTip(boolean z) {
        this.t = z;
        invalidate();
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.u = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.T = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.j = viewPager;
        if (viewPager.getAdapter() == null) {
            return;
        }
        viewPager.setOnPageChangeListener(this.f16330g);
        C();
    }

    public final float t(float f2, float f3, float f4) {
        if (f3 <= f2) {
            return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
        }
        double d2 = f4;
        if (d2 <= 0.5d) {
            return f2;
        }
        if (d2 <= 0.8d) {
            return f2 + ((((f3 + this.G) - f2) * (f4 - 0.5f)) / 0.3f);
        }
        int i2 = this.G;
        return (f3 + i2) - ((i2 * (f4 - 0.8f)) / 0.2f);
    }

    public final float u(float f2, View view) {
        return (f2 - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) + this.F;
    }

    public final float v(float f2, View view) {
        return (f2 + ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) - this.F;
    }

    public final float w(float f2, float f3, float f4) {
        if (f3 > f2) {
            return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
        }
        double d2 = f4;
        if (d2 >= 0.5d) {
            return f2;
        }
        if (d2 >= 0.2d) {
            return f2 - ((((this.G + f2) - f3) * (0.5f - f4)) / 0.3f);
        }
        int i2 = this.G;
        return (f3 - i2) + ((i2 * (0.2f - f4)) / 0.2f);
    }

    public final float x(float f2) {
        if (f2 <= 0.1f) {
            return 1.0f;
        }
        if (f2 <= 0.9f) {
            return (((1.0f - this.N) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
        }
        float f3 = this.N;
        return f3 + (((f3 - this.M) / (-0.100000024f)) * (f2 - 0.9f));
    }

    public View y(int i2) {
        return this.f16332i.getChildAt(i2);
    }

    public void z(int i2, int i3, int i4, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16332i = linearLayout;
        linearLayout.setOrientation(0);
        this.f16332i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f16332i);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
        this.H = (int) TypedValue.applyDimension(1, this.H, displayMetrics);
        this.I = (int) TypedValue.applyDimension(1, this.I, displayMetrics);
        this.J = i2;
        this.K = i3;
        int g2 = l.g(getContext(), R.dimen.tbds46);
        this.L = g2;
        int i5 = this.J;
        this.M = (this.K * 1.0f) / i5;
        this.N = (g2 * 1.0f) / i5;
        this.a0 = -l.g(getContext(), R.dimen.tbds11);
        this.D = i4;
        this.w = z;
        Paint paint = new Paint();
        this.q = paint;
        paint.setAntiAlias(true);
        this.q.setStyle(Paint.Style.FILL);
        this.q.setColor(SkinManager.getColor(R.color.CAM_X0302));
        Paint paint2 = new Paint();
        this.r = paint2;
        paint2.setAntiAlias(true);
        this.r.setStyle(Paint.Style.FILL);
        this.r.setColor(SkinManager.getColor(R.color.CAM_X0301));
        setLayerType(1, null);
        this.s = new RectF();
        this.O = l.g(getContext(), R.dimen.tbds20);
        this.P = (int) (l.g(getContext(), R.dimen.tbds28) * 0.5d);
        this.Q = (int) (l.g(getContext(), R.dimen.tbds22) * 0.4d);
        this.f16328e = new LinearLayout.LayoutParams(-2, -1);
        this.f16329f = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds165), -1);
        this.F = UtilHelper.getDimenPixelSize(R.dimen.tbds26) + Math.round(i2 * 0.5f);
        this.E = l.g(getContext(), R.dimen.tbds5);
        this.G = l.g(getContext(), R.dimen.tbds8);
        if (this.V == null) {
            this.V = getResources().getConfiguration().locale;
        }
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16330g = new d(this, null);
        this.l = 3;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.v = -1;
        this.w = false;
        int i3 = R.color.CAM_X0105;
        this.x = i3;
        this.y = i3;
        this.z = R.color.CAM_X0302;
        this.A = SkinManager.getColor(i3);
        this.B = SkinManager.getColor(this.y);
        this.C = 52;
        this.D = 4;
        this.H = 12;
        this.I = 1;
        this.J = 17;
        this.K = 17;
        this.R = 0;
        this.S = R.drawable.pager_sliding_view;
        this.T = false;
        this.U = false;
    }
}
