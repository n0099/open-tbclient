package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes11.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public float J;
    public float K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public Locale S;
    public RectF T;
    public c U;
    public ViewPager.OnPageChangeListener delegatePageListener;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f41520e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f41521f;

    /* renamed from: g  reason: collision with root package name */
    public final d f41522g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f41523h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager f41524i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41525j;
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
    public int u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes11.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabBaseStrip f41526e;

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
            this.f41526e = pagerSlidingTabBaseStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41526e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f41526e;
                pagerSlidingTabBaseStrip.m = pagerSlidingTabBaseStrip.f41524i.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = this.f41526e;
                pagerSlidingTabBaseStrip2.o = pagerSlidingTabBaseStrip2.m;
                this.f41526e.x();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = this.f41526e;
                pagerSlidingTabBaseStrip3.w(pagerSlidingTabBaseStrip3.m, 0);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41527e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabBaseStrip f41528f;

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
            this.f41528f = pagerSlidingTabBaseStrip;
            this.f41527e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41528f.R) {
                return;
            }
            if (this.f41528f.U != null) {
                this.f41528f.U.a(view, this.f41527e);
            }
            if (this.f41528f.f41524i.getCurrentItem() != this.f41527e) {
                this.f41528f.Q = true;
                this.f41528f.f41524i.setCurrentItem(this.f41527e);
                this.f41528f.x();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(View view, int i2);
    }

    /* loaded from: classes11.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabBaseStrip f41529e;

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
            this.f41529e = pagerSlidingTabBaseStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f41529e.f41523h.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f41529e;
                pagerSlidingTabBaseStrip.w(pagerSlidingTabBaseStrip.f41524i.getCurrentItem(), 0);
                this.f41529e.n = 0.0f;
                this.f41529e.Q = false;
                this.f41529e.R = false;
            } else if (i2 == 1) {
                this.f41529e.R = true;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip2 = this.f41529e;
                pagerSlidingTabBaseStrip2.p = pagerSlidingTabBaseStrip2.f41524i.getCurrentItem();
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip3 = this.f41529e;
                pagerSlidingTabBaseStrip3.m = pagerSlidingTabBaseStrip3.p;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip4 = this.f41529e;
                pagerSlidingTabBaseStrip4.o = pagerSlidingTabBaseStrip4.m;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f41529e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f41529e.f41523h.getChildCount() == 0) {
                return;
            }
            if (!this.f41529e.Q) {
                if (i2 == this.f41529e.p) {
                    this.f41529e.m = i2;
                    this.f41529e.o = i2 + 1;
                } else if (i2 > this.f41529e.p) {
                    this.f41529e.m = i2;
                    this.f41529e.o = i2 + 1;
                } else {
                    this.f41529e.m = i2 + 1;
                    this.f41529e.o = i2;
                }
                if (f2 == 0.0f) {
                    this.f41529e.p = i2;
                    this.f41529e.m = i2;
                    this.f41529e.o = i2;
                }
                this.f41529e.n = f2;
                PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f41529e;
                pagerSlidingTabBaseStrip.w(i2, (int) (pagerSlidingTabBaseStrip.f41523h.getChildAt(i2).getWidth() * f2));
                this.f41529e.x();
                this.f41529e.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f41529e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.f41529e.delegatePageListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
                if (this.f41529e.Q) {
                    PagerSlidingTabBaseStrip pagerSlidingTabBaseStrip = this.f41529e;
                    pagerSlidingTabBaseStrip.w(i2, (int) (pagerSlidingTabBaseStrip.n * this.f41529e.f41523h.getChildAt(i2).getWidth()));
                    this.f41529e.p = i2;
                    this.f41529e.m = i2;
                    this.f41529e.o = i2;
                }
                this.f41529e.invalidate();
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

    public View getTabView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f41523h.getChildAt(i2) : (View) invokeI.objValue;
    }

    public void init(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f41523h = linearLayout;
            linearLayout.setOrientation(0);
            this.f41523h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.f41523h);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.z = (int) TypedValue.applyDimension(1, this.z, displayMetrics);
            this.E = (int) TypedValue.applyDimension(1, this.E, displayMetrics);
            this.F = (int) TypedValue.applyDimension(1, this.F, displayMetrics);
            this.G = i2;
            this.H = i3;
            int f2 = n.f(getContext(), R.dimen.tbds74);
            this.I = f2;
            int i5 = this.G;
            this.J = (this.H * 1.0f) / i5;
            this.K = (f2 * 1.0f) / i5;
            this.A = i4;
            this.v = z;
            Paint paint = new Paint();
            this.q = paint;
            paint.setAntiAlias(true);
            this.q.setStyle(Paint.Style.FILL);
            this.q.setColor(SkinManager.getColor(R.color.CAM_X0312));
            Paint paint2 = new Paint();
            this.r = paint2;
            paint2.setAntiAlias(true);
            this.r.setStyle(Paint.Style.FILL);
            this.r.setColor(SkinManager.getColor(R.color.CAM_X0301));
            this.s = new RectF();
            this.L = n.f(getContext(), R.dimen.tbds20);
            this.M = n.f(getContext(), R.dimen.tbds28);
            this.N = n.f(getContext(), R.dimen.tbds22);
            this.f41520e = new LinearLayout.LayoutParams(-2, -1);
            this.f41521f = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds200), -1);
            this.C = n.f(getContext(), R.dimen.tbds22);
            this.B = n.f(getContext(), R.dimen.tbds20);
            this.D = n.f(getContext(), R.dimen.tbds15);
            if (this.S == null) {
                this.S = getResources().getConfiguration().locale;
            }
        }
    }

    public boolean isShowConcernRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean isTabItemClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    public void notifyDataSetChanged() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (viewPager = this.f41524i) == null || viewPager.getAdapter() == null || this.f41524i.getAdapter().getCount() == 0) {
            return;
        }
        this.f41523h.removeAllViews();
        this.k = this.f41524i.getAdapter().getCount();
        for (int i2 = 0; i2 < this.k; i2++) {
            r(i2, this.f41524i.getAdapter().getPageTitle(i2).toString());
        }
        x();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.l == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.l = TbadkCoreApplication.getInst().getSkinType();
        if (!this.f41525j) {
            this.x = SkinManager.getColor(this.w);
            this.y = SkinManager.getColor(R.color.CAM_X0107);
        } else {
            this.x = SkinManager.getColor(R.color.CAM_X0101);
            this.y = SkinManager.getColor(R.color.CAM_X0101);
        }
        this.q.setColor(SkinManager.getColor(R.color.CAM_X0312));
        this.r.setColor(SkinManager.getColor(R.color.CAM_X0301));
        x();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.k == 0) {
                return;
            }
            View childAt = this.f41523h.getChildAt(this.m);
            float left = childAt.getLeft() + this.C;
            float right = childAt.getRight() - this.C;
            if (this.n > 0.0f) {
                int i2 = this.m;
                int i3 = this.o;
                if (i2 != i3 && i3 <= this.k - 1 && i3 >= 0) {
                    View childAt2 = this.f41523h.getChildAt(i3);
                    left = t(left, childAt2.getLeft() + this.C, this.n);
                    right = u(right, childAt2.getRight() - this.C, this.n);
                }
            }
            int height = getHeight();
            RectF rectF = this.T;
            if (rectF == null) {
                int i4 = this.B;
                this.T = new RectF(left, (height - this.A) - i4, right, height - i4);
            } else {
                int i5 = this.B;
                rectF.set(left, (height - this.A) - i5, right, height - i5);
            }
            canvas.drawRoundRect(this.T, 16.0f, 16.0f, this.q);
            if (this.t) {
                View childAt3 = this.f41523h.getChildAt(this.u);
                int right2 = (childAt3.getRight() - this.N) - this.L;
                int top = childAt3.getTop() + this.M;
                int i6 = this.L;
                this.s.set(right2, top, right2 + i6, top + i6);
                canvas.drawOval(this.s, this.r);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i2 = savedState.currentPosition;
            this.m = i2;
            this.o = i2;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.m;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public final void q(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new b(this, i2));
            this.f41523h.addView(view, i2, this.v ? this.f41521f : this.f41520e);
        }
    }

    public final void r(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setGravity(17);
            textView.setTextSize(0, this.G);
            textView.setSingleLine();
            q(i2, textView);
        }
    }

    public final float s(float f2) {
        InterceptResult invokeF;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            if (f2 <= 0.1f) {
                f3 = this.J;
                f4 = (this.K - f3) / 0.1f;
            } else {
                f3 = this.K;
                f4 = (f3 - 1.0f) / (-0.9f);
                f2 -= 0.1f;
            }
            return f3 + (f4 * f2);
        }
        return invokeF.floatValue;
    }

    public void setConcernTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setDefaultSelectorColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, layoutParams) == null) {
            this.f41520e = layoutParams;
        }
    }

    public void setIndicatorOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.C = i2;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onPageChangeListener) == null) {
            this.delegatePageListener = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.U = cVar;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.t = z;
            invalidate();
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.Q = z;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, viewPager) == null) {
            this.f41524i = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f41522g);
            notifyDataSetChanged();
        }
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f41525j = z;
            if (!z) {
                this.x = SkinManager.getColor(this.w);
                this.y = SkinManager.getColor(R.color.CAM_X0107);
            } else {
                this.x = SkinManager.getColor(R.color.CAM_X0101);
                this.y = SkinManager.getColor(R.color.CAM_X0101);
            }
            x();
            invalidate();
        }
    }

    public final float t(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 <= f2) {
                return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 <= 0.5d) {
                return f2;
            }
            if (d2 <= 0.85d) {
                return f2 + ((((f3 + this.D) - f2) * (f4 - 0.5f)) / 0.35f);
            }
            int i2 = this.D;
            return (f3 + i2) - ((i2 * (f4 - 0.85f)) / 0.15f);
        }
        return invokeCommon.floatValue;
    }

    public final float u(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 > f2) {
                return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 >= 0.5d) {
                return f2;
            }
            if (d2 >= 0.15d) {
                return f2 - ((((f2 - this.D) - f3) * (0.5f - f4)) / 0.35f);
            }
            int i2 = this.D;
            return (f3 - i2) + ((i2 * (0.15f - f4)) / 0.15f);
        }
        return invokeCommon.floatValue;
    }

    public final float v(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048601, this, f2)) == null) {
            if (f2 <= 0.1f) {
                return 1.0f;
            }
            if (f2 <= 0.9f) {
                return (((1.0f - this.K) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
            }
            float f3 = this.K;
            return f3 + (((f3 - this.J) / (-0.100000024f)) * (f2 - 0.9f));
        }
        return invokeF.floatValue;
    }

    public final void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) || this.k == 0) {
            return;
        }
        int left = this.f41523h.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.z;
        }
        if (left != this.O) {
            this.O = left;
            scrollTo(left, 0);
        }
    }

    public final void x() {
        float v;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            float f2 = this.n;
            if (this.o < this.m) {
                f2 = 1.0f - f2;
            }
            int i2 = 0;
            while (i2 < this.k) {
                View childAt = this.f41523h.getChildAt(i2);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.P);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i2 == this.m) {
                            v = s(f2);
                        } else {
                            v = i2 == this.o ? v(f2) : 1.0f;
                        }
                        textView.setScaleX(v);
                        textView.setScaleY(v);
                        if (v <= 1.0f) {
                            textView.setTextColor(this.y);
                        } else {
                            textView.setTextColor(this.x);
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
        this.f41522g = new d(this, null);
        this.l = 3;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.v = false;
        int i5 = R.color.CAM_X0105;
        this.w = i5;
        this.x = SkinManager.getColor(i5);
        this.y = SkinManager.getColor(R.color.CAM_X0107);
        this.z = 52;
        this.A = 4;
        this.E = 12;
        this.F = 1;
        this.G = 17;
        this.H = 17;
        this.O = 0;
        this.P = R.drawable.pager_sliding_view;
        this.Q = false;
        this.R = false;
    }

    public void init(int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            init(i2, i3, i4, z);
            this.I = i5;
            this.K = (i5 * 1.0f) / this.G;
        }
    }
}
