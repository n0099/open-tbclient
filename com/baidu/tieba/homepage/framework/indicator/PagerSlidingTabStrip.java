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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import d.b.b.e.p.l;
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
    public LinearLayout.LayoutParams f17101e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f17102f;

    /* renamed from: g  reason: collision with root package name */
    public final d f17103g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f17104h;
    public LinearLayout i;
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
        public int f17105e;

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
            parcel.writeInt(this.f17105e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f17105e = parcel.readInt();
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
            PagerSlidingTabStrip.this.G();
            PagerSlidingTabStrip pagerSlidingTabStrip3 = PagerSlidingTabStrip.this;
            pagerSlidingTabStrip3.E(pagerSlidingTabStrip3.m, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17107e;

        public b(int i) {
            this.f17107e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PagerSlidingTabStrip.this.U) {
                return;
            }
            if (PagerSlidingTabStrip.this.b0 != null) {
                PagerSlidingTabStrip.this.b0.a(view, this.f17107e);
            }
            int currentItem = PagerSlidingTabStrip.this.j.getCurrentItem();
            int i = this.f17107e;
            if (currentItem != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.b.h0.b.d.h()) {
                if (PagerSlidingTabStrip.this.j.getCurrentItem() == this.f17107e) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_locate", this.f17107e + 1).param("obj_type", "1"));
                PagerSlidingTabStrip.this.T = true;
                if (PagerSlidingTabStrip.this.j.getAdapter() instanceof NewScrollFragmentAdapter) {
                    ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.j.getAdapter()).M(this.f17107e);
                }
                PagerSlidingTabStrip.this.j.setCurrentItem(this.f17107e);
                PagerSlidingTabStrip.this.G();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, int i);
    }

    /* loaded from: classes4.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.i.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.E(pagerSlidingTabStrip.j.getCurrentItem(), 0);
                PagerSlidingTabStrip.this.n = 0.0f;
                PagerSlidingTabStrip.this.T = false;
                PagerSlidingTabStrip.this.U = false;
            } else if (i == 1) {
                PagerSlidingTabStrip.this.U = true;
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.p = pagerSlidingTabStrip2.j.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip3.m = pagerSlidingTabStrip3.p;
                PagerSlidingTabStrip pagerSlidingTabStrip4 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip4.o = pagerSlidingTabStrip4.m;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f17104h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
            HomePageStatic.f16971a = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (PagerSlidingTabStrip.this.i.getChildCount() == 0) {
                return;
            }
            if (!PagerSlidingTabStrip.this.T) {
                if (i == PagerSlidingTabStrip.this.p) {
                    PagerSlidingTabStrip.this.m = i;
                    PagerSlidingTabStrip.this.o = i + 1;
                } else if (i > PagerSlidingTabStrip.this.p) {
                    PagerSlidingTabStrip.this.m = i;
                    PagerSlidingTabStrip.this.o = i + 1;
                } else {
                    PagerSlidingTabStrip.this.m = i + 1;
                    PagerSlidingTabStrip.this.o = i;
                }
                if (f2 == 0.0f) {
                    PagerSlidingTabStrip.this.p = i;
                    PagerSlidingTabStrip.this.m = i;
                    PagerSlidingTabStrip.this.o = i;
                }
                PagerSlidingTabStrip.this.n = f2;
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.E(i, (int) (pagerSlidingTabStrip.i.getChildAt(i).getWidth() * f2));
            }
            PagerSlidingTabStrip.this.G();
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f17104h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.f17104h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.T) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.E(i, (int) (pagerSlidingTabStrip.n * PagerSlidingTabStrip.this.i.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.p = i;
                PagerSlidingTabStrip.this.m = i;
                PagerSlidingTabStrip.this.o = i;
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
        this.i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i = 0; i < this.k; i++) {
            r(i, this.j.getAdapter().getPageTitle(i).toString());
        }
        G();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void D() {
        if (this.l != TbadkCoreApplication.getInst().getSkinType()) {
            this.l = TbadkCoreApplication.getInst().getSkinType();
            this.A = SkinManager.getColor(this.x);
            this.B = SkinManager.getColor(this.y);
            this.q.setColor(SkinManager.getColor(this.z));
            this.r.setColor(SkinManager.getColor(R.color.CAM_X0301));
            G();
            invalidate();
        }
    }

    public final void E(int i, int i2) {
        if (this.k == 0) {
            return;
        }
        int left = this.i.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.C;
        }
        if (left != this.R) {
            this.R = left;
            scrollTo(left, 0);
        }
    }

    public void F() {
        ViewPager viewPager = this.j;
        if (viewPager == null || viewPager.getAdapter() == null || this.j.getAdapter().getCount() == 0) {
            return;
        }
        this.i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i = 0; i < this.k; i++) {
            r(i, this.j.getAdapter().getPageTitle(i).toString());
        }
        G();
    }

    public final void G() {
        float x;
        float f2 = this.n;
        if (this.o < this.m) {
            f2 = 1.0f - f2;
        }
        int i = 0;
        while (i < this.k) {
            View childAt = this.i.getChildAt(i);
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
                    if (i == this.m) {
                        x = s(f2);
                    } else {
                        x = i == this.o ? x(f2) : 1.0f;
                    }
                    textView.setScaleX(x);
                    textView.setScaleY(x);
                    if (f2 >= 0.5f) {
                        if (i == this.o) {
                            textView.setTextColor(this.A);
                        } else {
                            textView.setTextColor(this.B);
                        }
                    } else if (i == this.m) {
                        textView.setTextColor(this.A);
                    } else {
                        textView.setTextColor(this.B);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.o) {
                            d.b.h0.r.u.c.a(textView).s(R.string.F_X02);
                        } else {
                            d.b.h0.r.u.c.a(textView).s(R.string.F_X01);
                        }
                    } else if (i == this.m) {
                        d.b.h0.r.u.c.a(textView).s(R.string.F_X02);
                    } else {
                        d.b.h0.r.u.c.a(textView).s(R.string.F_X01);
                    }
                }
            }
            i++;
        }
    }

    public int getCurrentTabIndex() {
        return this.m;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.k == 0) {
            return;
        }
        View childAt = this.i.getChildAt(this.m);
        float left = childAt.getLeft() + this.F;
        float right = childAt.getRight() - this.F;
        if ((childAt instanceof LinearLayout) && (((LinearLayout) childAt).getChildAt(0) instanceof TextView)) {
            float left2 = (childAt.getLeft() + childAt.getRight()) / 2.0f;
            right = v(left2, childAt);
            left = u(left2, childAt);
        }
        if (this.n > 0.0f) {
            int i = this.m;
            int i2 = this.o;
            if (i != i2 && i2 <= this.k - 1 && i2 >= 0) {
                View childAt2 = this.i.getChildAt(i2);
                float left3 = childAt2.getLeft() + this.F;
                float right2 = childAt2.getRight() - this.F;
                if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                    right2 = v(left4, childAt2);
                    left3 = u(left4, childAt2);
                }
                left = t(left, left3, this.n);
                right = w(right, right2, this.n);
            }
        }
        int height = getHeight();
        RectF rectF = this.W;
        if (rectF == null) {
            int i3 = this.E;
            this.W = new RectF(left, (height - this.D) - i3, right, height - i3);
        } else {
            int i4 = this.E;
            rectF.set(left, (height - this.D) - i4, right, height - i4);
        }
        RectF rectF2 = this.W;
        int i5 = this.D;
        canvas.drawRoundRect(rectF2, i5 * 0.5f, i5 * 0.5f, this.q);
        if (this.u) {
            View childAt3 = this.i.getChildAt(this.v);
            int right3 = (childAt3.getRight() - this.Q) - this.O;
            int top = childAt3.getTop() + this.P;
            int i6 = this.O;
            this.s.set(right3, top, right3 + i6, top + i6);
            canvas.drawOval(this.s, this.r);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f17105e;
        this.m = i;
        this.o = i;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f17105e = this.m;
        return savedState;
    }

    public final void q(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new b(i));
        if (i == 0 && (view instanceof LinearLayout) && d.b.h0.b.d.h()) {
            this.i.addView(view, i, this.f17101e);
        } else {
            this.i.addView(view, i, this.w ? this.f17102f : this.f17101e);
        }
    }

    public final void r(int i, String str) {
        String string;
        if (d.b.h0.b.d.h() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && d.b.h0.r.d0.b.i().j("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.J);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_home_unfold16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.a0;
            linearLayout.setGravity(16);
            q(i, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i == 0) {
            if (d.b.h0.b.d.h() && TbadkCoreApplication.isLogin() && d.b.h0.r.d0.b.i().j("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.J);
        eMTextView.setSingleLine();
        eMTextView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
        eMTextView.setGravity(17);
        eMTextView.setText(str);
        q(i, eMTextView);
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

    public void setConcernTabIndex(int i) {
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.f17102f = layoutParams;
    }

    public void setHotTopicIndex(int i) {
        this.v = i;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f17104h = onPageChangeListener;
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
        viewPager.setOnPageChangeListener(this.f17103g);
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
        int i = this.G;
        return (f3 + i) - ((i * (f4 - 0.8f)) / 0.2f);
    }

    public final float u(float f2, View view) {
        return (f2 - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) + this.F;
    }

    public final float v(float f2, View view) {
        return (f2 + ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) - this.F;
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
        int i = this.G;
        return (f3 - i) + ((i * (0.2f - f4)) / 0.2f);
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

    public View y(int i) {
        return this.i.getChildAt(i);
    }

    public void z(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.i = linearLayout;
        linearLayout.setOrientation(0);
        this.i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.i);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
        this.H = (int) TypedValue.applyDimension(1, this.H, displayMetrics);
        this.I = (int) TypedValue.applyDimension(1, this.I, displayMetrics);
        this.J = i;
        this.K = i2;
        int g2 = l.g(getContext(), R.dimen.tbds46);
        this.L = g2;
        int i4 = this.J;
        this.M = (this.K * 1.0f) / i4;
        this.N = (g2 * 1.0f) / i4;
        this.a0 = -l.g(getContext(), R.dimen.tbds11);
        this.D = i3;
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
        double g3 = l.g(getContext(), R.dimen.tbds28);
        Double.isNaN(g3);
        this.P = (int) (g3 * 0.5d);
        double g4 = l.g(getContext(), R.dimen.tbds22);
        Double.isNaN(g4);
        this.Q = (int) (g4 * 0.4d);
        this.f17101e = new LinearLayout.LayoutParams(-2, -1);
        this.f17102f = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds165), -1);
        this.F = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) + Math.round(i * 0.5f);
        this.E = l.g(getContext(), R.dimen.tbds5);
        this.G = l.g(getContext(), R.dimen.tbds8);
        if (this.V == null) {
            this.V = getResources().getConfiguration().locale;
        }
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17103g = new d(this, null);
        this.l = 3;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.w = false;
        int i2 = R.color.CAM_X0105;
        this.x = i2;
        this.y = i2;
        this.z = R.color.CAM_X0302;
        this.A = SkinManager.getColor(i2);
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
