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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public LinearLayout.LayoutParams f13566e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f13567f;

    /* renamed from: g  reason: collision with root package name */
    public final d f13568g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f13569h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f13570i;
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
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1217370892, "Lcom/baidu/tbadk/widget/tab/PagerSlidingTabBaseStrip$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1217370892, "Lcom/baidu/tbadk/widget/tab/PagerSlidingTabBaseStrip$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.currentPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.currentPosition = parcel.readInt();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabBaseStrip f13571e;

        public a(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13571e = pagerSlidingTabBaseStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13571e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f13571e;
                pagerSlidingTabBaseStrip.l = pagerSlidingTabBaseStrip.j.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = this.f13571e;
                pagerSlidingTabBaseStrip2.n = pagerSlidingTabBaseStrip2.l;
                this.f13571e.y();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = this.f13571e;
                pagerSlidingTabBaseStrip3.x(pagerSlidingTabBaseStrip3.l, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13572e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabBaseStrip f13573f;

        public b(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabBaseStrip, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13573f = pagerSlidingTabBaseStrip;
            this.f13572e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13573f.M) {
                return;
            }
            if (this.f13573f.O != null) {
                this.f13573f.O.a(view, this.f13572e);
            }
            if (this.f13573f.j.getCurrentItem() != this.f13572e) {
                this.f13573f.L = true;
                this.f13573f.j.setCurrentItem(this.f13572e);
                this.f13573f.y();
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabBaseStrip f13574e;

        public d(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13574e = pagerSlidingTabBaseStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f13574e.f13570i.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f13574e;
                pagerSlidingTabBaseStrip.x(pagerSlidingTabBaseStrip.j.getCurrentItem(), 0);
                this.f13574e.m = 0.0f;
                this.f13574e.L = false;
                this.f13574e.M = false;
            } else if (i2 == 1) {
                this.f13574e.M = true;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = this.f13574e;
                pagerSlidingTabBaseStrip2.o = pagerSlidingTabBaseStrip2.j.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = this.f13574e;
                pagerSlidingTabBaseStrip3.l = pagerSlidingTabBaseStrip3.o;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip4 = this.f13574e;
                pagerSlidingTabBaseStrip4.n = pagerSlidingTabBaseStrip4.l;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f13574e.f13569h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f13574e.f13570i.getChildCount() == 0) {
                return;
            }
            if (!this.f13574e.L) {
                if (i2 == this.f13574e.o) {
                    this.f13574e.l = i2;
                    this.f13574e.n = i2 + 1;
                } else if (i2 > this.f13574e.o) {
                    this.f13574e.l = i2;
                    this.f13574e.n = i2 + 1;
                } else {
                    this.f13574e.l = i2 + 1;
                    this.f13574e.n = i2;
                }
                if (f2 == 0.0f) {
                    this.f13574e.o = i2;
                    this.f13574e.l = i2;
                    this.f13574e.n = i2;
                }
                this.f13574e.m = f2;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f13574e;
                pagerSlidingTabBaseStrip.x(i2, (int) (pagerSlidingTabBaseStrip.f13570i.getChildAt(i2).getWidth() * f2));
                this.f13574e.y();
                this.f13574e.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f13574e.f13569h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.f13574e.f13569h;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
                if (this.f13574e.L) {
                    PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f13574e;
                    pagerSlidingTabBaseStrip.x(i2, (int) (pagerSlidingTabBaseStrip.m * this.f13574e.f13570i.getChildAt(i2).getWidth()));
                    this.f13574e.o = i2;
                    this.f13574e.l = i2;
                    this.f13574e.n = i2;
                }
                this.f13574e.invalidate();
            }
        }

        public /* synthetic */ d(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip, a aVar) {
            this(pagerSlidingTabBaseStrip);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.k == 0) {
                return;
            }
            View childAt = this.f13570i.getChildAt(this.l);
            float left = childAt.getLeft() + this.B;
            float right = childAt.getRight() - this.B;
            if (this.m > 0.0f) {
                int i2 = this.l;
                int i3 = this.n;
                if (i2 != i3 && i3 <= this.k - 1 && i3 >= 0) {
                    View childAt2 = this.f13570i.getChildAt(i3);
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
                View childAt3 = this.f13570i.getChildAt(this.t);
                int right2 = (childAt3.getRight() - this.I) - this.G;
                int top = childAt3.getTop() + this.H;
                int i6 = this.G;
                this.r.set(right2, top, right2 + i6, top + i6);
                canvas.drawOval(this.r, this.q);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i2 = savedState.currentPosition;
            this.l = i2;
            this.n = i2;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.l;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public final void q(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new b(this, i2));
            this.f13570i.addView(view, i2, this.u ? this.f13567f : this.f13566e);
        }
    }

    public final void r(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setGravity(17);
            textView.setTextSize(0, this.D);
            textView.setSingleLine();
            q(i2, textView);
        }
    }

    public final float s(float f2) {
        InterceptResult invokeF;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
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
        return invokeF.floatValue;
    }

    public void setConcernTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.t = i2;
        }
    }

    public void setDefaultSelectorColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.v = i2;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams) == null) {
            this.f13566e = layoutParams;
        }
    }

    public void setIndicatorOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onPageChangeListener) == null) {
            this.f13569h = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.O = cVar;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.s = z;
            invalidate();
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.L = z;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewPager) == null) {
            this.j = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f13568g);
            w();
        }
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
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
    }

    public final float t(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
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
        return invokeCommon.floatValue;
    }

    public final float u(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
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
        return invokeCommon.floatValue;
    }

    public final float v(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f2)) == null) {
            if (f2 <= 0.1f) {
                return 1.0f;
            }
            if (f2 <= 0.9f) {
                return (((1.0f - this.F) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
            }
            float f3 = this.F;
            return f3 + (((f3 - this.E) / (-0.100000024f)) * (f2 - 0.9f));
        }
        return invokeF.floatValue;
    }

    public void w() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (viewPager = this.j) == null || viewPager.getAdapter() == null || this.j.getAdapter().getCount() == 0) {
            return;
        }
        this.f13570i.removeAllViews();
        this.k = this.j.getAdapter().getCount();
        for (int i2 = 0; i2 < this.k; i2++) {
            r(i2, this.j.getAdapter().getPageTitle(i2).toString());
        }
        y();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public final void x(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) || this.k == 0) {
            return;
        }
        int left = this.f13570i.getChildAt(i2).getLeft() + i3;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            float f2 = this.m;
            if (this.n < this.l) {
                f2 = 1.0f - f2;
            }
            int i2 = 0;
            while (i2 < this.k) {
                View childAt = this.f13570i.getChildAt(i2);
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13568g = new d(this, null);
        this.l = 0;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.u = false;
        int i5 = R.color.CAM_X0105;
        this.v = i5;
        this.w = SkinManager.getColor(i5);
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
