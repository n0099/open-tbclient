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
    public float A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public RectF J;
    public c K;
    public LinearLayout.LayoutParams a;
    public LinearLayout.LayoutParams b;
    public final d c;
    public ViewPager.OnPageChangeListener d;
    public LinearLayout e;
    public ViewPager f;
    public int g;
    public int h;
    public float i;
    public int j;
    public int k;
    public Paint l;
    public Paint m;
    public RectF n;
    public boolean o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
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
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public final /* synthetic */ PagerSlidingTabBaseStrip a;

        public a(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSlidingTabBaseStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.a;
                pagerSlidingTabBaseStrip.h = pagerSlidingTabBaseStrip.f.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = this.a;
                pagerSlidingTabBaseStrip2.j = pagerSlidingTabBaseStrip2.h;
                this.a.y();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = this.a;
                pagerSlidingTabBaseStrip3.x(pagerSlidingTabBaseStrip3.h, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PagerSlidingTabBaseStrip b;

        public b(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabBaseStrip, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pagerSlidingTabBaseStrip;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.I) {
                return;
            }
            if (this.b.K != null) {
                this.b.K.a(view2, this.a);
            }
            if (this.b.f.getCurrentItem() != this.a) {
                this.b.H = true;
                this.b.f.setCurrentItem(this.a);
                this.b.y();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view2, int i);
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSlidingTabBaseStrip a;

        public d(PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSlidingTabBaseStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.e.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.a;
                pagerSlidingTabBaseStrip.x(pagerSlidingTabBaseStrip.f.getCurrentItem(), 0);
                this.a.i = 0.0f;
                this.a.H = false;
                this.a.I = false;
            } else if (i == 1) {
                this.a.I = true;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = this.a;
                pagerSlidingTabBaseStrip2.k = pagerSlidingTabBaseStrip2.f.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = this.a;
                pagerSlidingTabBaseStrip3.h = pagerSlidingTabBaseStrip3.k;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip4 = this.a;
                pagerSlidingTabBaseStrip4.j = pagerSlidingTabBaseStrip4.h;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || this.a.e.getChildCount() == 0) {
                return;
            }
            if (!this.a.H) {
                if (i == this.a.k) {
                    this.a.h = i;
                    this.a.j = i + 1;
                } else if (i > this.a.k) {
                    this.a.h = i;
                    this.a.j = i + 1;
                } else {
                    this.a.h = i + 1;
                    this.a.j = i;
                }
                if (f == 0.0f) {
                    this.a.k = i;
                    this.a.h = i;
                    this.a.j = i;
                }
                this.a.i = f;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.a;
                pagerSlidingTabBaseStrip.x(i, (int) (pagerSlidingTabBaseStrip.e.getChildAt(i).getWidth() * f));
                this.a.y();
                this.a.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                if (this.a.H) {
                    PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.a;
                    pagerSlidingTabBaseStrip.x(i, (int) (pagerSlidingTabBaseStrip.i * this.a.e.getChildAt(i).getWidth()));
                    this.a.k = i;
                    this.a.h = i;
                    this.a.j = i;
                }
                this.a.invalidate();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (isInEditMode() || this.g == 0) {
                return;
            }
            View childAt = this.e.getChildAt(this.h);
            float left = childAt.getLeft() + this.x;
            float right = childAt.getRight() - this.x;
            if (this.i > 0.0f) {
                int i = this.h;
                int i2 = this.j;
                if (i != i2 && i2 <= this.g - 1 && i2 >= 0) {
                    View childAt2 = this.e.getChildAt(i2);
                    left = t(left, childAt2.getLeft() + this.x, this.i);
                    right = u(right, childAt2.getRight() - this.x, this.i);
                }
            }
            int height = getHeight();
            RectF rectF = this.J;
            if (rectF == null) {
                int i3 = this.w;
                this.J = new RectF(left, (height - this.v) - i3, right, height - i3);
            } else {
                int i4 = this.w;
                rectF.set(left, (height - this.v) - i4, right, height - i4);
            }
            canvas.drawRoundRect(this.J, 16.0f, 16.0f, this.l);
            if (this.o) {
                View childAt3 = this.e.getChildAt(this.p);
                int right2 = (childAt3.getRight() - this.E) - this.C;
                int top = childAt3.getTop() + this.D;
                int i5 = this.C;
                this.n.set(right2, top, right2 + i5, top + i5);
                canvas.drawOval(this.n, this.m);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i = savedState.currentPosition;
            this.h = i;
            this.j = i;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.h;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public final void q(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, view2) == null) {
            view2.setFocusable(true);
            view2.setOnClickListener(new b(this, i));
            this.e.addView(view2, i, this.q ? this.b : this.a);
        }
    }

    public final void r(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setGravity(17);
            textView.setTextSize(0, this.z);
            textView.setSingleLine();
            q(i, textView);
        }
    }

    public final float s(float f) {
        InterceptResult invokeF;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            if (f <= 0.1f) {
                f2 = this.A;
                f3 = (this.B - f2) / 0.1f;
            } else {
                f2 = this.B;
                f3 = (f2 - 1.0f) / (-0.9f);
                f -= 0.1f;
            }
            return f2 + (f3 * f);
        }
        return invokeF.floatValue;
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.p = i;
        }
    }

    public void setDefaultSelectorColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.r = i;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams) == null) {
            this.a = layoutParams;
        }
    }

    public void setIndicatorOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.x = i;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onPageChangeListener) == null) {
            this.d = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.K = cVar;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
            invalidate();
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.H = z;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewPager) == null) {
            this.f = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.c);
            w();
        }
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (!z) {
                this.s = SkinManager.getColor(this.r);
                this.t = SkinManager.getColor(R.color.CAM_X0107);
            } else {
                this.s = SkinManager.getColor(R.color.CAM_X0101);
                this.t = SkinManager.getColor(R.color.CAM_X0101);
            }
            y();
            invalidate();
        }
    }

    public final float t(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 <= f) {
                return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
            }
            double d2 = f3;
            if (d2 <= 0.5d) {
                return f;
            }
            if (d2 <= 0.85d) {
                return f + ((((f2 + this.y) - f) * (f3 - 0.5f)) / 0.35f);
            }
            int i = this.y;
            return (f2 + i) - ((i * (f3 - 0.85f)) / 0.15f);
        }
        return invokeCommon.floatValue;
    }

    public final float u(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 > f) {
                return ((double) f3) <= 0.5d ? f + (((f2 - f) * f3) / 0.5f) : f2;
            }
            double d2 = f3;
            if (d2 >= 0.5d) {
                return f;
            }
            if (d2 >= 0.15d) {
                return f - ((((f - this.y) - f2) * (0.5f - f3)) / 0.35f);
            }
            int i = this.y;
            return (f2 - i) + ((i * (0.15f - f3)) / 0.15f);
        }
        return invokeCommon.floatValue;
    }

    public final float v(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f)) == null) {
            if (f <= 0.1f) {
                return 1.0f;
            }
            if (f <= 0.9f) {
                return (((1.0f - this.B) / (-0.79999995f)) * (f - 0.1f)) + 1.0f;
            }
            float f2 = this.B;
            return f2 + (((f2 - this.A) / (-0.100000024f)) * (f - 0.9f));
        }
        return invokeF.floatValue;
    }

    public void w() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (viewPager = this.f) == null || viewPager.getAdapter() == null || this.f.getAdapter().getCount() == 0) {
            return;
        }
        this.e.removeAllViews();
        this.g = this.f.getAdapter().getCount();
        for (int i = 0; i < this.g; i++) {
            r(i, this.f.getAdapter().getPageTitle(i).toString());
        }
        y();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public final void x(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) || this.g == 0) {
            return;
        }
        int left = this.e.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.u;
        }
        if (left != this.F) {
            this.F = left;
            scrollTo(left, 0);
        }
    }

    public final void y() {
        float v;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            float f = this.i;
            if (this.j < this.h) {
                f = 1.0f - f;
            }
            int i = 0;
            while (i < this.g) {
                View childAt = this.e.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.G);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i == this.h) {
                            v = s(f);
                        } else {
                            v = i == this.j ? v(f) : 1.0f;
                        }
                        textView.setScaleX(v);
                        textView.setScaleY(v);
                        if (v <= 1.0f) {
                            textView.setTextColor(this.t);
                        } else {
                            textView.setTextColor(this.s);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = new d(this, null);
        this.h = 0;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.q = false;
        this.r = R.color.CAM_X0105;
        this.s = SkinManager.getColor(R.color.CAM_X0105);
        this.t = SkinManager.getColor(R.color.CAM_X0107);
        this.u = 52;
        this.v = 4;
        this.z = 17;
        this.F = 0;
        this.G = R.drawable.obfuscated_res_0x7f080dfb;
        this.H = false;
        this.I = false;
    }
}
