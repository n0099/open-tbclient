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
/* loaded from: classes5.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public int I;
    public int J;
    public int K;
    public float L;
    public float M;
    public LinearLayout N;
    public TextView O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public LinearLayout.LayoutParams a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout.LayoutParams f30984b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f30985c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout.LayoutParams f30986d;

    /* renamed from: e  reason: collision with root package name */
    public final d f30987e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f30988f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f30989g;
    public Locale g0;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager f30990h;
    public RectF h0;
    public int i;
    public int i0;
    public int j;
    public c j0;
    public int k;
    public float l;
    public int m;
    public int n;
    public Paint o;
    public Paint p;
    public RectF q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes5.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1697402824, "Lcom/baidu/tbadk/widget/tab/NewPagerSlidingTabBaseStrip$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1697402824, "Lcom/baidu/tbadk/widget/tab/NewPagerSlidingTabBaseStrip$SavedState;");
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

    /* loaded from: classes5.dex */
    public class TabTextView extends TextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public Paint f30991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f30992c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabTextView(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30992c = newPagerSlidingTabBaseStrip;
            this.a = false;
            Paint paint = new Paint();
            this.f30991b = paint;
            paint.setColor(-16776961);
            this.f30991b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f30991b.setStrokeWidth(20.0f);
            this.f30991b.setAntiAlias(true);
            this.f30991b.setDither(true);
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                if (this.a) {
                    int width = (getWidth() - this.f30992c.S) - this.f30992c.Q;
                    int i = this.f30992c.R;
                    this.f30992c.q.set(width, i, width + this.f30992c.Q, i + this.f30992c.Q);
                    canvas.drawOval(this.f30992c.q, this.f30992c.p);
                }
            }
        }

        public void setHasRedDot(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewPagerSlidingTabBaseStrip a;

        public a(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newPagerSlidingTabBaseStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                newPagerSlidingTabBaseStrip.k = newPagerSlidingTabBaseStrip.f30990h.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.a;
                newPagerSlidingTabBaseStrip2.m = newPagerSlidingTabBaseStrip2.k;
                this.a.I();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.a;
                newPagerSlidingTabBaseStrip3.H(newPagerSlidingTabBaseStrip3.k, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f30993b;

        public b(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30993b = newPagerSlidingTabBaseStrip;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f30993b.W) {
                return;
            }
            if (this.f30993b.j0 != null) {
                this.f30993b.j0.a(view, this.a);
            }
            if (this.f30993b.f30990h.getCurrentItem() != this.a) {
                this.f30993b.V = true;
                this.f30993b.f30990h.setCurrentItem(this.a);
                this.f30993b.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view, int i);
    }

    /* loaded from: classes5.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewPagerSlidingTabBaseStrip a;

        public d(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newPagerSlidingTabBaseStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.f30989g.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                newPagerSlidingTabBaseStrip.H(newPagerSlidingTabBaseStrip.f30990h.getCurrentItem(), 0);
                this.a.l = 0.0f;
                this.a.V = false;
                this.a.W = false;
            } else if (i == 1) {
                this.a.W = true;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.a;
                newPagerSlidingTabBaseStrip2.n = newPagerSlidingTabBaseStrip2.f30990h.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.a;
                newPagerSlidingTabBaseStrip3.k = newPagerSlidingTabBaseStrip3.n;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip4 = this.a;
                newPagerSlidingTabBaseStrip4.m = newPagerSlidingTabBaseStrip4.k;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.f30988f;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.a.f30989g.getChildCount() == 0) {
                return;
            }
            if (!this.a.V) {
                if (i == this.a.n) {
                    this.a.k = i;
                    this.a.m = i + 1;
                } else if (i > this.a.n) {
                    this.a.k = i;
                    this.a.m = i + 1;
                } else {
                    this.a.k = i + 1;
                    this.a.m = i;
                }
                if (f2 == 0.0f) {
                    this.a.n = i;
                    this.a.k = i;
                    this.a.m = i;
                }
                this.a.l = f2;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                newPagerSlidingTabBaseStrip.H(i, (int) (newPagerSlidingTabBaseStrip.f30989g.getChildAt(i).getWidth() * f2));
                this.a.I();
                this.a.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.f30988f;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.a.f30988f;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                if (this.a.V) {
                    NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                    newPagerSlidingTabBaseStrip.H(i, (int) (newPagerSlidingTabBaseStrip.l * this.a.f30989g.getChildAt(i).getWidth()));
                    this.a.n = i;
                    this.a.k = i;
                    this.a.m = i;
                }
                if (this.a.f30989g.getChildAt(i) instanceof TabTextView) {
                    ((TabTextView) this.a.f30989g.getChildAt(i)).setHasRedDot(false);
                    this.a.f30989g.getChildAt(i).invalidate();
                }
                this.a.invalidate();
            }
        }

        public /* synthetic */ d(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, a aVar) {
            this(newPagerSlidingTabBaseStrip);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewPagerSlidingTabBaseStrip(Context context) {
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

    public final float A(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            if (f2 <= 0.1f) {
                return 1.0f;
            }
            if (f2 <= 0.9f) {
                return (((1.0f - this.M) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
            }
            float f3 = this.M;
            return f3 + (((f3 - this.L) / (-0.100000024f)) * (f2 - 0.9f));
        }
        return invokeF.floatValue;
    }

    public void B(int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            D(i, i2, i3, z);
            this.K = i4;
            this.M = (i4 * 1.0f) / this.I;
        }
    }

    public void C(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.s = z2;
            B(i, i2, i3, i4, z);
        }
    }

    public void D(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            if (this.s) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                this.N = linearLayout;
                linearLayout.setOrientation(0);
                FrameLayout.LayoutParams layoutParams = this.f30986d;
                if (layoutParams == null) {
                    this.N.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                } else {
                    this.N.setLayoutParams(layoutParams);
                }
                addView(this.N);
            }
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.f30989g = linearLayout2;
            linearLayout2.setOrientation(0);
            if (this.s) {
                this.f30989g.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                this.N.addView(this.f30989g);
            } else {
                this.f30989g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.f30989g);
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.y = (int) TypedValue.applyDimension(1, this.y, displayMetrics);
            this.F = (int) TypedValue.applyDimension(1, this.F, displayMetrics);
            this.G = (int) TypedValue.applyDimension(1, this.G, displayMetrics);
            this.I = i;
            this.J = i2;
            int f2 = n.f(getContext(), R.dimen.tbds74);
            this.K = f2;
            int i4 = this.I;
            this.L = (this.J * 1.0f) / i4;
            this.M = (f2 * 1.0f) / i4;
            this.z = i3;
            this.r = z;
            Paint paint = new Paint();
            this.o = paint;
            paint.setAntiAlias(true);
            this.o.setStyle(Paint.Style.FILL);
            this.o.setColor(SkinManager.getColor(this.t));
            Paint paint2 = new Paint();
            this.p = paint2;
            paint2.setAntiAlias(true);
            this.p.setStyle(Paint.Style.FILL);
            this.p.setColor(SkinManager.getColor(R.color.CAM_X0301));
            this.q = new RectF();
            this.Q = n.f(getContext(), R.dimen.tbds20);
            this.R = n.f(getContext(), R.dimen.tbds16);
            this.S = n.f(getContext(), R.dimen.tbds25);
            this.a = new LinearLayout.LayoutParams(-2, -1);
            this.f30984b = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds200), -1);
            this.B = n.f(getContext(), R.dimen.tbds22);
            this.A = n.f(getContext(), R.dimen.tbds20);
            this.D = n.f(getContext(), R.dimen.tbds15);
            if (this.g0 == null) {
                this.g0 = getResources().getConfiguration().locale;
            }
            if (!this.s || this.N == null) {
                return;
            }
            this.P = n.f(getContext(), R.dimen.tbds32);
            TextView textView = new TextView(getContext());
            this.O = textView;
            textView.setGravity(17);
            this.O.setTextSize(0, this.P);
            this.O.setSingleLine();
            this.O.setTextColor(this.x);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams2.gravity = 16;
            this.N.addView(this.O, layoutParams2);
        }
    }

    public void E() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (viewPager = this.f30990h) == null || viewPager.getAdapter() == null || this.f30990h.getAdapter().getCount() == 0) {
            return;
        }
        this.f30989g.removeAllViews();
        this.i = this.f30990h.getAdapter().getCount();
        boolean z = false;
        for (int i = 0; i < this.i; i++) {
            if (this.f30990h.getAdapter() instanceof c.a.o0.e1.o.a) {
                z = ((c.a.o0.e1.o.a) this.f30990h.getAdapter()).a(i);
            }
            w(i, this.f30990h.getAdapter().getPageTitle(i).toString(), z);
        }
        I();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void F(String str) {
        ViewPager viewPager;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (viewPager = this.f30990h) == null || viewPager.getAdapter() == null || this.f30990h.getAdapter().getCount() == 0 || !this.s || (textView = this.O) == null) {
            return;
        }
        textView.setText(str);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.j == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.j = TbadkCoreApplication.getInst().getSkinType();
        this.w = SkinManager.getColor(this.u);
        this.x = SkinManager.getColor(this.v);
        this.o.setColor(SkinManager.getColor(this.t));
        this.p.setColor(SkinManager.getColor(R.color.CAM_X0301));
        I();
        invalidate();
    }

    public final void H(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) || this.i == 0) {
            return;
        }
        int left = this.f30989g.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.y;
        }
        if (left != this.T) {
            this.T = left;
            scrollTo(left, 0);
        }
    }

    public final void I() {
        float A;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            float f2 = this.l;
            if (this.m < this.k) {
                f2 = 1.0f - f2;
            }
            int i = 0;
            while (i < this.i) {
                View childAt = this.f30989g.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.U);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i == this.k) {
                            A = x(f2);
                        } else {
                            A = i == this.m ? A(f2) : 1.0f;
                        }
                        textView.setScaleX(A);
                        textView.setScaleY(A);
                        int i2 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                        if (i2 >= 0) {
                            if (i == this.m) {
                                textView.setTextColor(this.w);
                            } else {
                                textView.setTextColor(this.x);
                            }
                        } else if (i == this.k) {
                            textView.setTextColor(this.w);
                        } else {
                            textView.setTextColor(this.x);
                        }
                        if (i2 >= 0) {
                            if (i == this.m) {
                                textView.setTypeface(Typeface.defaultFromStyle(1));
                            } else {
                                textView.setTypeface(Typeface.defaultFromStyle(0));
                            }
                        } else if (i == this.k) {
                            textView.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            textView.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    }
                }
                i++;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.i == 0) {
                return;
            }
            View childAt = this.f30989g.getChildAt(this.k);
            float f5 = 0.0f;
            if (childAt == null) {
                f2 = 0.0f;
                f3 = 0.0f;
            } else if (this.H && this.C > 0) {
                f3 = ((childAt.getLeft() + childAt.getRight()) - this.C) / 2;
                f2 = ((childAt.getLeft() + childAt.getRight()) + this.C) / 2;
            } else {
                f3 = childAt.getLeft() + this.B;
                f2 = childAt.getRight() - this.B;
            }
            if (this.l > 0.0f) {
                int i = this.k;
                int i2 = this.m;
                if (i != i2 && i2 <= this.i - 1 && i2 >= 0) {
                    View childAt2 = this.f30989g.getChildAt(i2);
                    if (childAt2 == null) {
                        f4 = 0.0f;
                    } else if (this.H && this.C > 0) {
                        f5 = ((childAt2.getLeft() + childAt2.getRight()) - this.C) / 2;
                        f4 = ((childAt2.getLeft() + childAt2.getRight()) + this.C) / 2;
                    } else {
                        f5 = childAt2.getLeft() + this.B;
                        f4 = childAt2.getRight() - this.B;
                    }
                    f3 = y(f3, f5, this.l);
                    f2 = z(f2, f4, this.l);
                }
            }
            int height = getHeight();
            RectF rectF = this.h0;
            if (rectF == null) {
                this.h0 = new RectF(f3 + getPaddingLeft(), (height - this.z) - this.A, f2 + getPaddingLeft(), height - this.A);
            } else {
                rectF.set(f3 + getPaddingLeft(), (height - this.z) - this.A, f2 + getPaddingLeft(), height - this.A);
            }
            RectF rectF2 = this.h0;
            int i3 = this.E;
            canvas.drawRoundRect(rectF2, i3, i3, this.o);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i = savedState.currentPosition;
            this.k = i;
            this.m = i;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.k;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, layoutParams) == null) {
            this.f30986d = layoutParams;
        }
    }

    public void setDefaultSelectorColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.u = i;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, layoutParams) == null) {
            this.a = layoutParams;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, layoutParams) == null) {
            this.f30984b = layoutParams;
        }
    }

    public void setIndicatorMarginBottom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.A = i;
        }
    }

    public void setIndicatorOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.B = i;
            this.H = false;
        }
    }

    public void setIndicatorOvershot(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.D = i;
        }
    }

    public void setIndicatorRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.E = i;
        }
    }

    public void setNormalSelectorColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.v = i;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onPageChangeListener) == null) {
            this.f30988f = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.j0 = cVar;
        }
    }

    public void setRectPaintColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.t = i;
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.V = z;
        }
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i, i2, i3, i4) == null) {
            this.f30985c = r0;
            int[] iArr = {i, i2, i3, i4};
        }
    }

    public void setTextViewShadowStringArrayId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.i0 = i;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, viewPager) == null) {
            this.f30990h = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f30987e);
            E();
        }
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (!z) {
                this.u = R.color.CAM_X0105;
                this.v = R.color.CAM_X0107;
            } else {
                this.u = R.color.CAM_X0101;
                this.v = R.color.CAM_X0101;
            }
            this.w = SkinManager.getColor(this.u);
            this.x = SkinManager.getColor(this.v);
            I();
            invalidate();
        }
    }

    public void setmIndicatorWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.C = i;
            this.H = true;
        }
    }

    public final void v(int i, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048607, this, i, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new b(this, i));
            int[] iArr = this.f30985c;
            if (iArr != null && iArr.length == 4) {
                view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            this.f30989g.addView(view, i, this.r ? this.f30984b : this.a);
        }
    }

    public final void w(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            TabTextView tabTextView = new TabTextView(this, getContext());
            tabTextView.setHasRedDot(z);
            tabTextView.setText(str);
            if (this.i0 != 0) {
                c.a.o0.r.v.c.d(tabTextView).y(this.i0);
            }
            tabTextView.setGravity(17);
            tabTextView.setTextSize(0, this.I);
            tabTextView.setMaxLines(1);
            v(i, tabTextView);
        }
    }

    public final float x(float f2) {
        InterceptResult invokeF;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f2)) == null) {
            if (f2 <= 0.1f) {
                f3 = this.L;
                f4 = (this.M - f3) / 0.1f;
            } else {
                f3 = this.M;
                f4 = (f3 - 1.0f) / (-0.9f);
                f2 -= 0.1f;
            }
            return f3 + (f4 * f2);
        }
        return invokeF.floatValue;
    }

    public final float y(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 <= f2) {
                return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 <= 0.5d) {
                return f2;
            }
            if (d2 <= 0.8d) {
                return f2 + ((((f3 + this.D) - f2) * (f4 - 0.5f)) / 0.3f);
            }
            int i = this.D;
            return (f3 + i) - ((i * (f4 - 0.8f)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float z(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 > f2) {
                return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 >= 0.5d) {
                return f2;
            }
            if (d2 >= 0.2d) {
                return f2 - ((((this.D + f2) - f3) * (0.5f - f4)) / 0.3f);
            }
            int i = this.D;
            return (f3 - i) + ((i * (0.2f - f4)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
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
    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
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
        this.f30987e = new d(this, null);
        this.j = 3;
        this.k = 0;
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        this.r = false;
        this.s = false;
        this.t = R.color.CAM_X0312;
        this.u = R.color.CAM_X0105;
        this.v = R.color.CAM_X0107;
        this.w = SkinManager.getColor(R.color.CAM_X0105);
        this.x = SkinManager.getColor(this.v);
        this.y = 52;
        this.z = 4;
        this.E = 16;
        this.F = 12;
        this.G = 1;
        this.H = false;
        this.I = 17;
        this.J = 17;
        this.T = 0;
        this.U = R.drawable.obfuscated_res_0x7f080e52;
        this.V = false;
        this.W = false;
        this.i0 = 0;
    }
}
