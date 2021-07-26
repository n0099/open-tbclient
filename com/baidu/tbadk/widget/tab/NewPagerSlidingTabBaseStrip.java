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
import d.a.d.e.p.l;
import java.util.Locale;
/* loaded from: classes3.dex */
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
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public float P;
    public float Q;
    public LinearLayout R;
    public TextView S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int a0;
    public int b0;
    public boolean c0;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f13604e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f13605f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f13606g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f13607h;

    /* renamed from: i  reason: collision with root package name */
    public final d f13608i;
    public boolean i0;
    public ViewPager.OnPageChangeListener j;
    public Locale j0;
    public LinearLayout k;
    public RectF k0;
    public ViewPager l;
    public c l0;
    public int m;
    public int n;
    public int o;
    public float p;
    public int q;
    public int r;
    public Paint s;
    public Paint t;
    public RectF u;
    public boolean v;
    public boolean w;
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
    public class TabTextView extends TextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13609e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f13610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f13611g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabTextView(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13611g = newPagerSlidingTabBaseStrip;
            this.f13609e = false;
            Paint paint = new Paint();
            this.f13610f = paint;
            paint.setColor(-16776961);
            this.f13610f.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f13610f.setStrokeWidth(20.0f);
            this.f13610f.setAntiAlias(true);
            this.f13610f.setDither(true);
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                if (this.f13609e) {
                    int width = (getWidth() - this.f13611g.W) - this.f13611g.U;
                    int i2 = this.f13611g.V;
                    this.f13611g.u.set(width, i2, width + this.f13611g.U, i2 + this.f13611g.U);
                    canvas.drawOval(this.f13611g.u, this.f13611g.t);
                }
            }
        }

        public void setHasRedDot(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f13609e = z;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f13612e;

        public a(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13612e = newPagerSlidingTabBaseStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13612e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f13612e;
                newPagerSlidingTabBaseStrip.o = newPagerSlidingTabBaseStrip.l.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.f13612e;
                newPagerSlidingTabBaseStrip2.q = newPagerSlidingTabBaseStrip2.o;
                this.f13612e.I();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.f13612e;
                newPagerSlidingTabBaseStrip3.H(newPagerSlidingTabBaseStrip3.o, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f13613e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f13614f;

        public b(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13614f = newPagerSlidingTabBaseStrip;
            this.f13613e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13614f.i0) {
                return;
            }
            if (this.f13614f.l0 != null) {
                this.f13614f.l0.a(view, this.f13613e);
            }
            if (this.f13614f.l.getCurrentItem() != this.f13613e) {
                this.f13614f.c0 = true;
                this.f13614f.l.setCurrentItem(this.f13613e);
                this.f13614f.I();
            }
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
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f13615e;

        public d(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13615e = newPagerSlidingTabBaseStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f13615e.k.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f13615e;
                newPagerSlidingTabBaseStrip.H(newPagerSlidingTabBaseStrip.l.getCurrentItem(), 0);
                this.f13615e.p = 0.0f;
                this.f13615e.c0 = false;
                this.f13615e.i0 = false;
            } else if (i2 == 1) {
                this.f13615e.i0 = true;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.f13615e;
                newPagerSlidingTabBaseStrip2.r = newPagerSlidingTabBaseStrip2.l.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.f13615e;
                newPagerSlidingTabBaseStrip3.o = newPagerSlidingTabBaseStrip3.r;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip4 = this.f13615e;
                newPagerSlidingTabBaseStrip4.q = newPagerSlidingTabBaseStrip4.o;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f13615e.j;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f13615e.k.getChildCount() == 0) {
                return;
            }
            if (!this.f13615e.c0) {
                if (i2 == this.f13615e.r) {
                    this.f13615e.o = i2;
                    this.f13615e.q = i2 + 1;
                } else if (i2 > this.f13615e.r) {
                    this.f13615e.o = i2;
                    this.f13615e.q = i2 + 1;
                } else {
                    this.f13615e.o = i2 + 1;
                    this.f13615e.q = i2;
                }
                if (f2 == 0.0f) {
                    this.f13615e.r = i2;
                    this.f13615e.o = i2;
                    this.f13615e.q = i2;
                }
                this.f13615e.p = f2;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f13615e;
                newPagerSlidingTabBaseStrip.H(i2, (int) (newPagerSlidingTabBaseStrip.k.getChildAt(i2).getWidth() * f2));
                this.f13615e.I();
                this.f13615e.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f13615e.j;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.f13615e.j;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
                if (this.f13615e.c0) {
                    NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f13615e;
                    newPagerSlidingTabBaseStrip.H(i2, (int) (newPagerSlidingTabBaseStrip.p * this.f13615e.k.getChildAt(i2).getWidth()));
                    this.f13615e.r = i2;
                    this.f13615e.o = i2;
                    this.f13615e.q = i2;
                }
                if (this.f13615e.k.getChildAt(i2) instanceof TabTextView) {
                    ((TabTextView) this.f13615e.k.getChildAt(i2)).setHasRedDot(false);
                    this.f13615e.k.getChildAt(i2).invalidate();
                }
                this.f13615e.invalidate();
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

    public final float A(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            if (f2 <= 0.1f) {
                return 1.0f;
            }
            if (f2 <= 0.9f) {
                return (((1.0f - this.Q) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
            }
            float f3 = this.Q;
            return f3 + (((f3 - this.P) / (-0.100000024f)) * (f2 - 0.9f));
        }
        return invokeF.floatValue;
    }

    public void B(int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            D(i2, i3, i4, z);
            this.O = i5;
            this.Q = (i5 * 1.0f) / this.M;
        }
    }

    public void C(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.w = z2;
            B(i2, i3, i4, i5, z);
        }
    }

    public void D(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            if (this.w) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                this.R = linearLayout;
                linearLayout.setOrientation(0);
                FrameLayout.LayoutParams layoutParams = this.f13607h;
                if (layoutParams == null) {
                    this.R.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                } else {
                    this.R.setLayoutParams(layoutParams);
                }
                addView(this.R);
            }
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.k = linearLayout2;
            linearLayout2.setOrientation(0);
            if (this.w) {
                this.k.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                this.R.addView(this.k);
            } else {
                this.k.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.k);
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
            this.J = (int) TypedValue.applyDimension(1, this.J, displayMetrics);
            this.K = (int) TypedValue.applyDimension(1, this.K, displayMetrics);
            this.M = i2;
            this.N = i3;
            int g2 = l.g(getContext(), R.dimen.tbds74);
            this.O = g2;
            int i5 = this.M;
            this.P = (this.N * 1.0f) / i5;
            this.Q = (g2 * 1.0f) / i5;
            this.D = i4;
            this.v = z;
            Paint paint = new Paint();
            this.s = paint;
            paint.setAntiAlias(true);
            this.s.setStyle(Paint.Style.FILL);
            this.s.setColor(SkinManager.getColor(this.x));
            Paint paint2 = new Paint();
            this.t = paint2;
            paint2.setAntiAlias(true);
            this.t.setStyle(Paint.Style.FILL);
            this.t.setColor(SkinManager.getColor(R.color.CAM_X0301));
            this.u = new RectF();
            this.U = l.g(getContext(), R.dimen.tbds20);
            this.V = l.g(getContext(), R.dimen.tbds16);
            this.W = l.g(getContext(), R.dimen.tbds25);
            this.f13604e = new LinearLayout.LayoutParams(-2, -1);
            this.f13605f = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds200), -1);
            this.F = l.g(getContext(), R.dimen.tbds22);
            this.E = l.g(getContext(), R.dimen.tbds20);
            this.H = l.g(getContext(), R.dimen.tbds15);
            if (this.j0 == null) {
                this.j0 = getResources().getConfiguration().locale;
            }
            if (!this.w || this.R == null) {
                return;
            }
            this.T = l.g(getContext(), R.dimen.tbds32);
            TextView textView = new TextView(getContext());
            this.S = textView;
            textView.setGravity(17);
            this.S.setTextSize(0, this.T);
            this.S.setSingleLine();
            this.S.setTextColor(this.B);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams2.gravity = 16;
            this.R.addView(this.S, layoutParams2);
        }
    }

    public void E() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (viewPager = this.l) == null || viewPager.getAdapter() == null || this.l.getAdapter().getCount() == 0) {
            return;
        }
        this.k.removeAllViews();
        this.m = this.l.getAdapter().getCount();
        boolean z = false;
        for (int i2 = 0; i2 < this.m; i2++) {
            if (this.l.getAdapter() instanceof d.a.p0.d1.n.a) {
                z = ((d.a.p0.d1.n.a) this.l.getAdapter()).a(i2);
            }
            w(i2, this.l.getAdapter().getPageTitle(i2).toString(), z);
        }
        I();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void F(String str) {
        ViewPager viewPager;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (viewPager = this.l) == null || viewPager.getAdapter() == null || this.l.getAdapter().getCount() == 0 || !this.w || (textView = this.S) == null) {
            return;
        }
        textView.setText(str);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.n == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.n = TbadkCoreApplication.getInst().getSkinType();
        this.A = SkinManager.getColor(this.y);
        this.B = SkinManager.getColor(this.z);
        this.s.setColor(SkinManager.getColor(this.x));
        this.t.setColor(SkinManager.getColor(R.color.CAM_X0301));
        I();
        invalidate();
    }

    public final void H(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) || this.m == 0) {
            return;
        }
        int left = this.k.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.C;
        }
        if (left != this.a0) {
            this.a0 = left;
            scrollTo(left, 0);
        }
    }

    public final void I() {
        float A;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            float f2 = this.p;
            if (this.q < this.o) {
                f2 = 1.0f - f2;
            }
            int i2 = 0;
            while (i2 < this.m) {
                View childAt = this.k.getChildAt(i2);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.b0);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i2 == this.o) {
                            A = x(f2);
                        } else {
                            A = i2 == this.q ? A(f2) : 1.0f;
                        }
                        textView.setScaleX(A);
                        textView.setScaleY(A);
                        int i3 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                        if (i3 >= 0) {
                            if (i2 == this.q) {
                                textView.setTextColor(this.A);
                            } else {
                                textView.setTextColor(this.B);
                            }
                        } else if (i2 == this.o) {
                            textView.setTextColor(this.A);
                        } else {
                            textView.setTextColor(this.B);
                        }
                        if (i3 >= 0) {
                            if (i2 == this.q) {
                                textView.setTypeface(Typeface.defaultFromStyle(1));
                            } else {
                                textView.setTypeface(Typeface.defaultFromStyle(0));
                            }
                        } else if (i2 == this.o) {
                            textView.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            textView.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    }
                }
                i2++;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float left;
        float right;
        float left2;
        float right2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.m == 0) {
                return;
            }
            View childAt = this.k.getChildAt(this.o);
            if (this.L && this.G > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.G) / 2;
                right = ((childAt.getLeft() + childAt.getRight()) + this.G) / 2;
            } else {
                left = childAt.getLeft() + this.F;
                right = childAt.getRight() - this.F;
            }
            if (this.p > 0.0f) {
                int i2 = this.o;
                int i3 = this.q;
                if (i2 != i3 && i3 <= this.m - 1 && i3 >= 0) {
                    View childAt2 = this.k.getChildAt(i3);
                    if (this.L && this.G > 0) {
                        left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.G) / 2;
                        right2 = ((childAt2.getLeft() + childAt2.getRight()) + this.G) / 2;
                    } else {
                        left2 = childAt2.getLeft() + this.F;
                        right2 = childAt2.getRight() - this.F;
                    }
                    left = y(left, left2, this.p);
                    right = z(right, right2, this.p);
                }
            }
            int height = getHeight();
            RectF rectF = this.k0;
            if (rectF == null) {
                this.k0 = new RectF(left + getPaddingLeft(), (height - this.D) - this.E, right + getPaddingLeft(), height - this.E);
            } else {
                rectF.set(left + getPaddingLeft(), (height - this.D) - this.E, right + getPaddingLeft(), height - this.E);
            }
            RectF rectF2 = this.k0;
            int i4 = this.I;
            canvas.drawRoundRect(rectF2, i4, i4, this.s);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i2 = savedState.currentPosition;
            this.o = i2;
            this.q = i2;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.o;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setConcernTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, layoutParams) == null) {
            this.f13607h = layoutParams;
        }
    }

    public void setDefaultSelectorColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, layoutParams) == null) {
            this.f13604e = layoutParams;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, layoutParams) == null) {
            this.f13605f = layoutParams;
        }
    }

    public void setIndicatorMarginBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.E = i2;
        }
    }

    public void setIndicatorOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.F = i2;
            this.L = false;
        }
    }

    public void setIndicatorOvershot(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.H = i2;
        }
    }

    public void setIndicatorRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.I = i2;
        }
    }

    public void setNormalSelectorColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onPageChangeListener) == null) {
            this.j = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.l0 = cVar;
        }
    }

    public void setRectPaintColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.c0 = z;
        }
    }

    public void setTabPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i2, i3, i4, i5) == null) {
            this.f13606g = r0;
            int[] iArr = {i2, i3, i4, i5};
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, viewPager) == null) {
            this.l = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f13608i);
            E();
        }
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (!z) {
                this.y = R.color.CAM_X0105;
                this.z = R.color.CAM_X0107;
            } else {
                int i2 = R.color.CAM_X0101;
                this.y = i2;
                this.z = i2;
            }
            this.A = SkinManager.getColor(this.y);
            this.B = SkinManager.getColor(this.z);
            I();
            invalidate();
        }
    }

    public void setmIndicatorWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.G = i2;
            this.L = true;
        }
    }

    public final void v(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i2, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new b(this, i2));
            int[] iArr = this.f13606g;
            if (iArr != null && iArr.length == 4) {
                view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            this.k.addView(view, i2, this.v ? this.f13605f : this.f13604e);
        }
    }

    public final void w(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            TabTextView tabTextView = new TabTextView(this, getContext());
            tabTextView.setHasRedDot(z);
            tabTextView.setText(str);
            tabTextView.setGravity(17);
            tabTextView.setTextSize(0, this.M);
            tabTextView.setMaxLines(1);
            v(i2, tabTextView);
        }
    }

    public final float x(float f2) {
        InterceptResult invokeF;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048608, this, f2)) == null) {
            if (f2 <= 0.1f) {
                f3 = this.P;
                f4 = (this.Q - f3) / 0.1f;
            } else {
                f3 = this.Q;
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 <= f2) {
                return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 <= 0.5d) {
                return f2;
            }
            if (d2 <= 0.8d) {
                return f2 + ((((f3 + this.H) - f2) * (f4 - 0.5f)) / 0.3f);
            }
            int i2 = this.H;
            return (f3 + i2) - ((i2 * (f4 - 0.8f)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float z(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 > f2) {
                return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 >= 0.5d) {
                return f2;
            }
            if (d2 >= 0.2d) {
                return f2 - ((((this.H + f2) - f3) * (0.5f - f4)) / 0.3f);
            }
            int i2 = this.H;
            return (f3 - i2) + ((i2 * (0.2f - f4)) / 0.2f);
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
    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13608i = new d(this, null);
        this.n = 3;
        this.o = 0;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.v = false;
        this.w = false;
        this.x = R.color.CAM_X0312;
        int i5 = R.color.CAM_X0105;
        this.y = i5;
        this.z = R.color.CAM_X0107;
        this.A = SkinManager.getColor(i5);
        this.B = SkinManager.getColor(this.z);
        this.C = 52;
        this.D = 4;
        this.I = 16;
        this.J = 12;
        this.K = 1;
        this.L = false;
        this.M = 17;
        this.N = 17;
        this.a0 = 0;
        this.b0 = R.drawable.pager_sliding_view;
        this.c0 = false;
        this.i0 = false;
    }
}
